package com.lujiahao.trade.order.service;

import com.lujiahao.trade.common.protocol.order.ConfirmOrderReq;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderRes;

/**
 * @author lujiahao
 * @date 2018-06-12 下午10:00
 */
public interface IOrderService {

    ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq);
}
