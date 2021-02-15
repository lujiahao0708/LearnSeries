package com.lujiahao.strategy.v2_strategy;

import com.lujiahao.strategy.OrderDTO;
import com.lujiahao.strategy.OrderTypeEnum;
import com.lujiahao.strategy.v2_strategy.strategy.AbstractStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 取消订单处理逻辑
 * 策略模式实现
 * @author lujiahao
 * @date 2019-05-22 11:17
 */
@Service
public class CancelOrderStrategyService {

    @Autowired
    private StrategyContext context;

    /**
     * 处理取消逻辑
     */
    public void process(OrderDTO orderDTO) {
        OrderTypeEnum orderTypeEnum = OrderTypeEnum.getByCode(orderDTO.getServiceType());
        AbstractStrategy strategy = context.getStrategy(orderTypeEnum);
        strategy.process(orderDTO);
    }
}
