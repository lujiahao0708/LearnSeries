package com.lujiahao.canal.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 记录日志
 * @author lujiahao
 * @date 2018/10/21
 */
public class LogRejectedExecutionHandler implements RejectedExecutionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.error("rejectedExecution", new RejectedExecutionException("Task " + r.toString() +
                                                                                   " rejected from " +
                                                                                executor.toString()));
    }
}
