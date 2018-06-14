package com.lujiahao.trade.order.api;

import com.lujiahao.trade.common.api.IGoodsApi;
import com.lujiahao.trade.common.protocol.goods.QueryGoodsReq;
import com.lujiahao.trade.common.protocol.goods.QueryGoodsRes;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberReq;
import com.lujiahao.trade.common.protocol.goods.ReduceGoodsNumberRes;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lujiahao
 * @date 2018-06-13 下午2:47
 */
@RestController
public class GoodsApiImpl implements IGoodsApi {
    @Override
    public QueryGoodsRes queryGoods(QueryGoodsReq queryGoodsReq) {
        return null;
    }

    @Override
    public ReduceGoodsNumberRes reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq) {
        return null;
    }
}
