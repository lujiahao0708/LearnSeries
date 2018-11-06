package com.lujiahao.lifecycle;

import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 客户端启动基类
 * @author lujiahao
 * @date 2018/11/3
 */
@Configuration
public class LifeCycleBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, LifeCycle> map;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event == null) {
            return;
        }

        ApplicationContext applicationContext = event.getApplicationContext();
        if (null == applicationContext || null != applicationContext.getParent()) {
            return;
        }

        map = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, LifeCycle.class, false, false);
        if (MapUtils.isNotEmpty(map)) {
            map.forEach((k ,v) -> {
                v.start();
                if (v.isStart()) {
                    logger.info("lifeCycle 启动成功 class:[{}]", v.getClass());
                }
            });
        }
    }

    @PreDestroy
    public void preDestroy() {
        if (MapUtils.isEmpty(map)) {
            return;
        }

        for (Entry<String, LifeCycle> entry : map.entrySet()) {
            try {
                entry.getValue().shutdown();
            } catch (Exception e) {
                logger.error("shutdown error class:[{}]", entry.getValue().getClass());
            }
        }
    }
}
