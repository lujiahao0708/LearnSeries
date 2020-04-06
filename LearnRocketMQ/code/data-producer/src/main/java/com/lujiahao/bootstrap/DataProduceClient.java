package com.lujiahao.bootstrap;

import com.lujiahao.service.DataGeneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送客户端
 * @author lujiahao
 * @date 2018-11-03 15:03
 */
@Component
public class DataProduceClient implements LifeCycle {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProduceClient.class);

    private volatile boolean running = false;
    private Thread thread = null;
    protected Thread.UncaughtExceptionHandler handler = (t, e) -> LOGGER.error("parse events has an error", e);

    @Autowired
    private DataGeneService dataGeneService;

    @Override
    public void start() {
        thread = new Thread(() -> dataGeneService.sendSingleMsg());
        thread.setUncaughtExceptionHandler(handler);
        thread.start();
        running = true;
    }

    @Override
    public void stop() {
        if (!running) {
            return;
        }

        running = false;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public boolean isStart() {
        return running;
    }


}
