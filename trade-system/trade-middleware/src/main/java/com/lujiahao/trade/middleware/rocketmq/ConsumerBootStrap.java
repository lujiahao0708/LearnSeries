package com.lujiahao.trade.middleware.rocketmq;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * consumer启动类
 * @author lujiahao
 * @date 2018-06-06 上午11:34
 */
@Component
public class ConsumerBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, IConsumer> map;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (contextRefreshedEvent == null) {
            return;
        }

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (null == applicationContext || null != applicationContext.getParent()) {
            return;
        }

        map = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, IConsumer.class, false, false);

        if (MapUtils.isEmpty(map)) {
            logger.warn("无注册的consumer");
            return;
        }

        for (IConsumer worker : map.values()) {
            worker.start();
        }

        logger.info("consumer启动");
    }

    @PreDestroy
    public void destroy() {
        if (MapUtils.isNotEmpty(map)) {
            for (IConsumer worker : map.values()) {
                worker.stop();
            }
            logger.info("consumer关闭");
        }
    }
}
