package com.lujiahao.trade.common.protocol.user;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:59
 */
@Data
public class ChangeUserMoneyReq {
    private Integer userId;
    private BigDecimal userMoney;
    private String moneyLogType;
    private String orderId;

}
