package com.lujiahao.concurrent.chapter08;

/**
 * 任务队列,主要用于缓存提交到线程池中的任务
 * 该队列是一个BlockedQueue,并且有limit限制
 * @author lujiahao
 * @date 2019-11-26
 */
public interface RunnableQueue {
    /**
     * 当有新的任务进来时首先会offer到队列中
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取runnable
     */
    Runnable take() throws InterruptedException;

    /**
     * 获取任务队列中任务的数量
     */
    int size();
}
