package com.lujiahao.strategy.v2_strategy;

import com.google.common.collect.Maps;
import com.lujiahao.strategy.OrderTypeEnum;
import com.lujiahao.utils.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 策略处理器
 * @author lujiahao
 * @date 2019-05-22 17:04
 */
@Component
public class StrategyProcessor implements BeanFactoryPostProcessor {

    private static final String STRATEGY_PACKAGE = "com.lujiahao.strategy";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<OrderTypeEnum, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scan(STRATEGY_PACKAGE, OrderTypeAnnotation.class).forEach(clazz -> {
            // 获取注解中的类型值
            OrderTypeEnum type = clazz.getAnnotation(OrderTypeAnnotation.class).orderType();
            handlerMap.put(type, clazz);
        });

        // 初始化HandlerContext,将其注册到spring容器中
        StrategyContext context = new StrategyContext(handlerMap);
        configurableListableBeanFactory.registerSingleton(StrategyContext.class.getName(), context);
    }
}

