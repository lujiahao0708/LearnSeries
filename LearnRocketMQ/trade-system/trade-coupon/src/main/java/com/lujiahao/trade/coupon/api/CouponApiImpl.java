package com.lujiahao.trade.coupon.api;

import com.lujiahao.trade.common.api.ICouponApi;
import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.lujiahao.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponReq;
import com.lujiahao.trade.common.protocol.coupon.QueryCouponRes;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lujiahao
 * @date 2018-06-13 下午2:45
 */
@RestController
public class CouponApiImpl implements ICouponApi {
    @Override
    public QueryCouponRes queryCoupon(QueryCouponReq queryCouponReq) {
        return null;
    }

    @Override
    public ChangeCouponStatusRes changeCouponStatus(ChangeCouponStatusReq changeCouponStatusReq) {
        return null;
    }
}
