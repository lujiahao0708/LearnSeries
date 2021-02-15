package com.lujiahao.strategy.v2_strategy.strategy;

import com.lujiahao.strategy.OrderDTO;

/**
 * 策略抽象类
 * @author lujiahao
 * @date 2019-05-22 11:21
 */
public abstract class AbstractStrategy {

    abstract public void process(OrderDTO orderDTO);
}
