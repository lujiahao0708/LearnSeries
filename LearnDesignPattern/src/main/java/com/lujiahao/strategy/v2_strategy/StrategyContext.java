package com.lujiahao.strategy.v2_strategy;

import com.lujiahao.strategy.OrderTypeEnum;
import com.lujiahao.strategy.v2_strategy.strategy.AbstractStrategy;
import com.lujiahao.utils.SpringBeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * 策略上下文
 * @author lujiahao
 * @date 2019-05-22 11:44
 */
public class StrategyContext {
    private Map<OrderTypeEnum, Class> strategyMap;

    public StrategyContext(Map<OrderTypeEnum, Class> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public AbstractStrategy getStrategy(OrderTypeEnum orderTypeEnum) {
        if (orderTypeEnum == null) {
            throw new IllegalArgumentException("not fond enum");
        }

        if (CollectionUtils.isEmpty(strategyMap)) {
            throw new IllegalArgumentException("strategy map is empty,please check you strategy package path");
        }

        Class clazz = strategyMap.get(orderTypeEnum);
        if (clazz == null) {
            throw new IllegalArgumentException("not fond strategy for type:" + orderTypeEnum.getCode());
        }

        return (AbstractStrategy) SpringBeanUtils.getBean(clazz);
    }
}
