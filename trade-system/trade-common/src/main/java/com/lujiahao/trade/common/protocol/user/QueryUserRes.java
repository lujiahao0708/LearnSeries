package com.lujiahao.trade.common.protocol.user;

import com.lujiahao.trade.common.protocol.BaseRes;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lujiahao
 * @date 2018-06-07 下午1:50
 */
@Data
public class QueryUserRes extends BaseRes {

    private Integer userId;

    private String userName;

    private String userMobile;

    private Integer userScore;

    private Date userRegTime;

    private BigDecimal userMoney;
}
