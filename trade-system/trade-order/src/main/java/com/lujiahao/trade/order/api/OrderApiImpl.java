package com.lujiahao.trade.order.api;

import com.lujiahao.trade.common.api.IOrderApi;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderReq;
import com.lujiahao.trade.common.protocol.order.ConfirmOrderRes;
import com.lujiahao.trade.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lujiahao
 * @date 2018-06-11 下午10:20
 */
@RestController
public class OrderApiImpl implements IOrderApi {

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/confirmOrder")
    public ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq) {
        return orderService.confirmOrder(confirmOrderReq);
    }
}
