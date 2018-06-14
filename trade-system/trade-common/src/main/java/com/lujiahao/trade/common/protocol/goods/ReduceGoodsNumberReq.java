package com.lujiahao.trade.common.protocol.goods;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:56
 */
@Data
public class ReduceGoodsNumberReq {
    private Integer goodsId;
    private Integer goodsNumber;
    private String orderId;
    
}
