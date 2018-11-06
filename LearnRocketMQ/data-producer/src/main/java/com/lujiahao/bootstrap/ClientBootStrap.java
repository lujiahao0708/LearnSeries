package com.lujiahao.bootstrap;

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
 * 启动客户端
 * @author lujiahao
 * @date 2018/10/20
 */
@Component
public class ClientBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, LifeCycle> map = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent == null) {
            return;
        }

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (null == applicationContext || null != applicationContext.getParent()) {
            return;
        }

        map = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, LifeCycle.class, false, false);
        if (map == null || map.isEmpty()) {
            logger.warn("未启动任何管理器");
            return;
        }

        for (LifeCycle lifeCycle : map.values()) {
            lifeCycle.start();
            if (lifeCycle.isStart()) {
                logger.info("className:{} 已启动", lifeCycle.getClass().getName());
            }
        }
    }

    /**
     * 销毁生命周期
     *
     */
    @PreDestroy
    public void preDestroy() {
        if (map == null || map.isEmpty()) {
            return;
        }

        for (LifeCycle lifeCycle : map.values()) {
            lifeCycle.stop();
            if (!lifeCycle.isStart()) {
                logger.info("className:{} 已关闭", lifeCycle.getClass().getName());
            }
        }
    }
}
