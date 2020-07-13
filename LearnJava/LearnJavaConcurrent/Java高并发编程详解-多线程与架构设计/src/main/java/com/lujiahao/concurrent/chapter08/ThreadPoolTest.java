package com.lujiahao.concurrent.chapter08;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new BasicThreadPool(2,6,4, 1000);
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " is running and done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (; ;) {
            System.out.printf("activeCount:%d coreSize:%d maxSize:%d queueSize:%d\n",
                    threadPool.getActiveCount(), threadPool.getCoreSize(), threadPool.getMaxSize(), threadPool.getQueueSize());
            System.out.println("=========================================");
            TimeUnit.SECONDS.sleep(1);

            //Thread.currentThread().getThreadGroup().list();
        }

//        TimeUnit.SECONDS.sleep(12);
//        // 线程池在12s后被shutdown
//        threadPool.shutdown();
//        // 使main线程join,方便观察
//        Thread.currentThread().join();
    }
}
