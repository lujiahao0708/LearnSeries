package com.lujiahao.trade.common.protocol.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:34
 */
@Data
public class ConfirmOrderReq {
    private Integer userId;
    private String address;
    private String consignee;
    private Integer goodsId;
    private Integer goodsNumber;
    /** 优惠券id */
    private String couponId;
    /** 余额支付*/
    private BigDecimal moneyPaid;
    /** 物品单价 */
    private BigDecimal goodsPrice;
    /** 运费*/
    private BigDecimal shippingFee;
    /** 订单总价 */
    private BigDecimal orderAmount;
}
