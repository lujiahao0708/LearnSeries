package com.lujiahao.concurrent.chapter08;

/**
 * 是Runnable的一个实现,用于线程池内部
 * 不断从RunnableQueue中取出某个runnable,并运行run方法
 * @author lujiahao
 * @date 2019-11-26
 */
public class InternalTask implements Runnable{

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        /**
         * 如果当前任务为running并且没有被中断,将不断的从queue中获取runnable,然后执行run方法
         */
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable take = runnableQueue.take();
                take.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务,主要会在线程池的shutdown方法中使用
     */
    public void stop() {
        this.running = false;
    }
}
