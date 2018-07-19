package com.lujiahao.trade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.lujiahao.trade.common.api.ICouponApi;
import com.lujiahao.trade.common.api.IGoodsApi;
import com.lujiahao.trade.common.api.IUserApi;
import com.lujiahao.trade.common.constants.MQEnum;
import com.lujiahao.trade.common.constants.TradeEnum;
import com.lujiahao.trade.common.exception.OrderException;
import com.lujiahao.trade.common.exception.RocketMqException;
import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponReq;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponRes;
import com.lujiahao.trade.common.protocol.goods.QueryGoodsReq;
import com.lujiahao.trade.common.protocol.goods.QueryGoodsRes;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberReq;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberRes;
import com.lujiahao.trade.common.protocol.mq.OrderCancelMQ;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderReq;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderRes;
import com.lujiahao.trade.common.protocol.user.ChangeUserMoneyReq;
import com.lujiahao.trade.common.protocol.user.ChangeUserMoneyRes;
import com.lujiahao.trade.common.protocol.user.QueryUserReq;
import com.lujiahao.trade.common.protocol.user.QueryUserRes;
import com.lujiahao.trade.common.utils.IDGenerator;
import com.lujiahao.trade.dao.entity.TradeOrder;
import com.lujiahao.trade.dao.mapper.TradeOrderMapper;
import com.lujiahao.trade.middleware.rocketmq.TradeProducer;
import com.lujiahao.trade.order.service.IOrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lujiahao
 * @date 2018-06-12 下午10:01
 */
@Service
public class OrderServiceImpl implements IOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private IGoodsApi goodsApi;
    @Autowired
    private TradeOrderMapper tradeOrderMapper;
    @Autowired
    private ICouponApi couponApi;
    @Autowired
    private IUserApi userApi;

    @Autowired
    private TradeProducer producer;

    @Override
    public ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq) {
        ConfirmOrderRes confirmOrderRes = new ConfirmOrderRes();
        confirmOrderRes.setRetCode(TradeEnum.RetEnum.SUCCESS.getCode());
        try {
            QueryGoodsReq queryGoodsReq = new QueryGoodsReq();
            queryGoodsReq.setGoodsId(confirmOrderReq.getGoodsId());
            QueryGoodsRes queryGoodsRes = goodsApi.queryGoods(queryGoodsReq);
            // 1.校验
            checkConfirmOrderReq(confirmOrderReq, queryGoodsRes);
            // 2.创建不可见订单
            String orderId = saveNoConfirmOrder(confirmOrderReq);
            // 3.d调用远程服务,扣优惠券,扣库存,扣余额.
            // 如果调用成功,更改订单状态可见;如果失败,发送mq消息,取消订单
            callRemoteService(orderId, confirmOrderReq);
        } catch (Exception e) {
            confirmOrderRes.setRetCode(TradeEnum.RetEnum.FAIL.getCode());
            confirmOrderRes.setRetInfo(e.getMessage());
        }
        return confirmOrderRes;
    }

    private void callRemoteService(String orderId, ConfirmOrderReq confirmOrderReq) {
        try {
            // 调用优惠券
            if (StringUtils.isNotBlank(confirmOrderReq.getCouponId())) {
                ChangeCouponStatusReq changeCouponStatusReq = new ChangeCouponStatusReq();
                changeCouponStatusReq.setCouponId(confirmOrderReq.getCouponId());
                changeCouponStatusReq.setOrderId(orderId);
                changeCouponStatusReq.setIsUsed(TradeEnum.YesNoEnum.YES.getCode());
                ChangeCouponStatusRes changeCouponStatusRes = couponApi.changeCouponStatus(changeCouponStatusReq);
                if (changeCouponStatusRes == null || !changeCouponStatusRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
                    throw new OrderException("优惠券使用失败");
                }
            }
            // 扣余额
            if (confirmOrderReq.getMoneyPaid() != null && confirmOrderReq.getMoneyPaid().compareTo(BigDecimal.ZERO) == 1) {
                ChangeUserMoneyReq changeUserMoneyReq = new ChangeUserMoneyReq();
                changeUserMoneyReq.setOrderId(orderId);
                changeUserMoneyReq.setUserId(confirmOrderReq.getUserId());
                changeUserMoneyReq.setUserMoney(confirmOrderReq.getMoneyPaid());
                changeUserMoneyReq.setMoneyLogType(TradeEnum.UserMonyLogTypeEnum.PAID.getCode());
                ChangeUserMoneyRes changeUserMoneyRes = userApi.changeUserMoney(changeUserMoneyReq);
                if (changeUserMoneyRes == null || !changeUserMoneyRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
                    throw new OrderException("扣余额失败");
                }
            }
            // 扣库存
            ReduceGoodsNumberReq reduceGoodsNumberReq = new ReduceGoodsNumberReq();
            reduceGoodsNumberReq.setOrderId(orderId);
            reduceGoodsNumberReq.setGoodsId(confirmOrderReq.getGoodsId());
            reduceGoodsNumberReq.setGoodsNumber(confirmOrderReq.getGoodsNumber());
            ReduceGoodsNumberRes reduceGoodsNumberRes = goodsApi.reduceGoodsNumber(reduceGoodsNumberReq);
            if (reduceGoodsNumberRes == null && !reduceGoodsNumberRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
                throw new OrderException("扣库存失败");
            }
            // 更新订单状态
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setOrderId(orderId);
            tradeOrder.setOrderStatus(TradeEnum.OrderStatusEnum.CONFIRM.getStatusCode());
            tradeOrder.setConfirmTime(new Date());
            int i = tradeOrderMapper.updateByPrimaryKeySelective(tradeOrder);
            if (i < 0) {
                throw new OrderException("更改订单状态失败");
            }
        } catch (Exception e) {
            // 发送mq消息
            OrderCancelMQ orderCancelMQ = new OrderCancelMQ();
            orderCancelMQ.setOrderId(orderId);
            orderCancelMQ.setUserId(confirmOrderReq.getUserId());
            orderCancelMQ.setGoodsId(confirmOrderReq.getGoodsId());
            orderCancelMQ.setGoodsNumber(confirmOrderReq.getGoodsNumber());
            orderCancelMQ.setCouponId(confirmOrderReq.getCouponId());
            try {
                SendResult sendResult = this.producer.sendMessage(MQEnum.TopicEnum.ORDER_CANCEL, orderId, JSON.toJSONString(orderCancelMQ));
                System.out.println(sendResult);
            } catch (RocketMqException e1) {
                e1.printStackTrace();
            }
        }
    }

    private String saveNoConfirmOrder(ConfirmOrderReq confirmOrderReq) {
        TradeOrder tradeOrder = new TradeOrder();
        String orderId = IDGenerator.generateUUID();
        tradeOrder.setOrderId(orderId);
        tradeOrder.setUserId(confirmOrderReq.getUserId());
        tradeOrder.setOrderStatus(TradeEnum.OrderStatusEnum.NO_CONFIRM.getStatusCode());
        tradeOrder.setPayStatus(TradeEnum.PayStatusEnum.NO_PAY.getStatusCode());
        tradeOrder.setShippingStatus(TradeEnum.ShippingStatusEnum.NO_SHIP.getStatusCode());
        tradeOrder.setAddress(confirmOrderReq.getAddress());
        tradeOrder.setConsignee(confirmOrderReq.getConsignee());
        tradeOrder.setGoodsId(confirmOrderReq.getGoodsId());
        tradeOrder.setGoodsNumber(confirmOrderReq.getGoodsNumber());
        tradeOrder.setGoodsPrice(confirmOrderReq.getGoodsPrice());
        BigDecimal goodsAmount = confirmOrderReq.getGoodsPrice().multiply(new BigDecimal(confirmOrderReq.getGoodsNumber()));
        tradeOrder.setGoodsAmount(goodsAmount);
        BigDecimal shippingFee = calShippingFee(goodsAmount);
        if (confirmOrderReq.getShippingFee().compareTo(shippingFee) != 0) {
            throw new OrderException("快递费用不正确");
        }
        tradeOrder.setShippingFee(shippingFee);
        BigDecimal orderAmount = goodsAmount.add(shippingFee);
        if (confirmOrderReq.getOrderAmount().compareTo(orderAmount) != 0) {
            throw new OrderException("订单总价异常");
        }
        tradeOrder.setOrderAmount(orderAmount);
        String couponId = confirmOrderReq.getCouponId();
        if (StringUtils.isNotBlank(couponId)) {
            QueryCouponReq queryCouponReq = new QueryCouponReq();
            queryCouponReq.setCouponId(couponId);
            QueryCouponRes queryCouponRes = couponApi.queryCoupon(queryCouponReq);
            if (queryCouponRes == null || !queryCouponRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
                throw new OrderException("优惠券非法");
            }
            if (!queryCouponRes.getIsUsed().equals(TradeEnum.YesNoEnum.NO.getCode())) {
                throw new OrderException("优惠券已使用");
            }
            tradeOrder.setCouponId(couponId);
            tradeOrder.setCouponPaid(queryCouponRes.getCouponPrice());
        } else {
            tradeOrder.setCouponPaid(BigDecimal.ZERO);
        }

        // 余额支付
        if (confirmOrderReq.getMoneyPaid() != null) {
            int i = confirmOrderReq.getMoneyPaid().compareTo(BigDecimal.ZERO);
            if (i == -1) {
                throw new OrderException("余额金额非法");
            }
            if (i == 1) {
                // 判断用户余额是否够用
                QueryUserReq queryUserReq = new QueryUserReq();
                queryUserReq.setUserId(confirmOrderReq.getUserId());
                QueryUserRes queryUserRes = userApi.queryUserById(queryUserReq);
                if (queryUserRes == null || !queryUserRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
                    throw new OrderException("用户非法");
                }
                if (queryUserRes.getUserMoney().compareTo(confirmOrderReq.getMoneyPaid()) == -1) {
                    throw new OrderException("余额不足");
                }
                tradeOrder.setMoneyPaid(confirmOrderReq.getMoneyPaid());
            }
        } else {
            tradeOrder.setMoneyPaid(BigDecimal.ZERO);
        }

        BigDecimal payAmount = orderAmount.subtract(tradeOrder.getMoneyPaid()).subtract(tradeOrder.getCouponPaid());
        tradeOrder.setPayAmount(payAmount);
        tradeOrder.setAddTime(new Date());

        int insert = tradeOrderMapper.insert(tradeOrder);
        if (insert != 1) {
            throw new OrderException("保存不可见订单失效");
        }

        return orderId;
    }

    private void checkConfirmOrderReq(ConfirmOrderReq confirmOrderReq, QueryGoodsRes queryGoodsRes) {
        if (confirmOrderReq == null) {
            throw new OrderException("下单信息不能为空");
        }
        if (confirmOrderReq.getUserId() == null) {
            throw new OrderException("会员信息不能空空");
        }
        if (confirmOrderReq.getGoodsId() == null) {
            throw new OrderException("商品id不能为空");
        }
        if (confirmOrderReq.getGoodsNumber() == null || confirmOrderReq.getGoodsNumber() < 0) {
            throw new OrderException("购买数量不能小于0");
        }
        if (confirmOrderReq.getAddress() == null) {
            throw new OrderException("收货地址不能为空");
        }
        if (queryGoodsRes == null || !queryGoodsRes.getRetCode().equals(TradeEnum.RetEnum.SUCCESS.getCode())) {
            throw new OrderException("未查询到该商品:" + confirmOrderReq.getGoodsId());
        }
        if (queryGoodsRes.getGoodsNumber() < confirmOrderReq.getGoodsNumber()) {
            throw new OrderException("商品库存不足");
        }
        if (queryGoodsRes.getGoodsPrice().compareTo(confirmOrderReq.getGoodsPrice()) != 0) {
            throw new OrderException("商品价格变化请重新下单");
        }
        if (confirmOrderReq.getShippingFee() == null) {
            confirmOrderReq.setShippingFee(BigDecimal.ZERO);
        }
        if (confirmOrderReq.getOrderAmount() == null) {
            confirmOrderReq.setOrderAmount(BigDecimal.ZERO);
        }
    }

    private BigDecimal calShippingFee(BigDecimal goodsAmount) {
        if (goodsAmount.doubleValue() > 100.00) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.TEN;
    }
}
