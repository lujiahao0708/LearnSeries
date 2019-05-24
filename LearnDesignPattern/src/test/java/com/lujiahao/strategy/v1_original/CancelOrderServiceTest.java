package com.lujiahao.strategy.v1_original;

import com.lujiahao.BaseTestCase;
import com.lujiahao.strategy.OrderDTO;
import com.lujiahao.strategy.OrderTypeEnum;
import com.lujiahao.strategy.v2_strategy.CancelOrderStrategyService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CancelOrderServiceTest extends BaseTestCase {

    @Autowired
    private CancelOrderService cancelOrderService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void handle() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setServiceType(OrderTypeEnum.INSTANT.getCode());
        cancelOrderService.process(orderDTO);
    }
}