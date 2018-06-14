package com.lujiahao.trade.common.protocol.coupon;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:50
 */
@Data
public class ChangeCouponStatusReq {
    private String couponId;
    private String orderId;
    private String isUsed;
}
