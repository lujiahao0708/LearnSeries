package com.lujiahao.trade.common.api;

import com.lujiahao.trade.common.protocol.order.ConfirmOrderReq;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderRes;
import org.springframework.stereotype.Component;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:19
 */
public interface IOrderApi {

    ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq);
}
