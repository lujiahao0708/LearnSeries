package com.lujiahao.trade.common.api;

import com.lujiahao.trade.common.protocol.goods.QueryGoodsReq;
import com.lujiahao.trade.common.protocol.goods.QueryGoodsRes;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberReq;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberRes;
import org.springframework.stereotype.Component;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:52
 */
public interface IGoodsApi {

    QueryGoodsRes queryGoods(QueryGoodsReq queryGoodsReq);

    ReduceGoodsNumberRes reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq);
}
