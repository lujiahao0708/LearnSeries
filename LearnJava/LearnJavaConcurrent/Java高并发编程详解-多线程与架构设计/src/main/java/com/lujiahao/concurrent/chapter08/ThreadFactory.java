package com.lujiahao.concurrent.chapter08;

/**
 * 创建线程工厂
 * @author lujiahao
 * @date 2019-11-26
 */
@FunctionalInterface
public interface ThreadFactory {
    /**
     * 创建线程
     */
    Thread createThread(Runnable runnable);
}
