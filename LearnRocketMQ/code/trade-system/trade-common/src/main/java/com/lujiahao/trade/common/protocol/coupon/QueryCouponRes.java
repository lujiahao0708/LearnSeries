package com.lujiahao.trade.common.protocol.coupon;

import com.lujiahao.trade.common.protocol.BaseRes;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:43
 */
@Data
public class QueryCouponRes extends BaseRes {
    private String couponId;

    private BigDecimal couponPrice;

    private Integer userId;

    private String orderId;

    private String isUsed;

    private BigDecimal usedTime;

}
