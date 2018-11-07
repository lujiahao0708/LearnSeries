package com.lujiahao.service.queue;

import com.lujiahao.lifecycle.AbstractLifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 队列抽象类
 * @author lujiahao
 * @date 2018-11-06 15:59
 */
public abstract class AbsQueueService extends AbstractLifeCycle {
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbsQueueService.class);

    protected static volatile boolean running = false;

    @Override
    public void start() {
        running = true;
        running = handleMessage();
    }

    @Override
    public boolean isStart() {
        return running;
    }

    @Override
    public void shutdown() {
        if (!running) {
            return;
        }

        running = false;
    }

    public abstract boolean handleMessage();
}
