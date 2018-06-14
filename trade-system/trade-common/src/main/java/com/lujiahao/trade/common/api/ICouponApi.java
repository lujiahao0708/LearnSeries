package com.lujiahao.trade.common.api;

import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponReq;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponRes;
import org.springframework.stereotype.Component;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:48
 */
public interface ICouponApi {
    QueryCouponRes queryCoupon(QueryCouponReq queryCouponReq);

    ChangeCouponStatusRes changeCouponStatus(ChangeCouponStatusReq changeCouponStatusReq);

}
