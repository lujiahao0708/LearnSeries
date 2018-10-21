package com.lujiahao.canal.client.bootstrap;

import com.lujiahao.canal.client.cycle.LifeCycle;
import com.lujiahao.canal.client.handler.Handler;
import com.lujiahao.canal.client.handler.HandlerChain;
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
 * 启动canal客户端
 * @author lujiahao
 * @date 2018/10/20
 */
@Component
public class CanalClientBootStrap implements ApplicationListener<ContextRefreshedEvent> {

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

        Map<String, Handler> handlerMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, Handler.class, false, false);
        HandlerChain chain = applicationContext.getBean(HandlerChain.class);
        if (handlerMap == null || handlerMap.isEmpty()) {
            logger.warn("未找到任何处理器,启动失败");
            return;
        }

        // 责任链串联
        handlerMap.values().stream().forEach(handler -> chain.addHandler(handler));

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
