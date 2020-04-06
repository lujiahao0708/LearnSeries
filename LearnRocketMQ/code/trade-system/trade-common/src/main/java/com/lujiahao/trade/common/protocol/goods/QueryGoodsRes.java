package com.lujiahao.trade.common.protocol.goods;

import com.lujiahao.trade.common.protocol.BaseRes;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:54
 */
@Data
public class QueryGoodsRes extends BaseRes {
    private Integer goodsId;

    private String goodsName;

    private Integer goodsNumber;

    private BigDecimal goodsPrice;

    private String goodsDesc;

    private Date addTime;
}
