package com.lujiahao.strategy.v2_strategy;

import com.lujiahao.BaseTestCase;
import com.lujiahao.strategy.OrderDTO;
import com.lujiahao.strategy.OrderTypeEnum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CancelOrderStrategyServiceTest extends BaseTestCase {

    @Autowired
    private CancelOrderStrategyService cancelOrderStrategyService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setServiceType(OrderTypeEnum.INSTANT.getCode());
        cancelOrderStrategyService.process(orderDTO);
    }
}