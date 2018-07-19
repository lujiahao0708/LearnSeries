package com.lujiahao.trade.common.protocol.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lujiahao
 * @date 2018-06-13 下午1:58
 */
@Data
public class OrderCancelMQ {
    private String orderId;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNumber;
    private String couponId;
    private BigDecimal userMoney;
}
