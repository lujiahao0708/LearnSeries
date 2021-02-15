package com.lujiahao.javaconcurrency.juc.synchronizer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch switcher = new CountDownLatch(1);
//        switchMethod(switcher);
//
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(Thread.currentThread().getName() + " 开关开启");
//        switcher.countDown();

        int N = 3;
        CountDownLatch finishSignal = new CountDownLatch(N);
        finishMethod(N, finishSignal);
        System.out.println(Thread.currentThread().getName() + " 主线程等待其它N个线程完成");
        finishSignal.await();
    }

    /** 作为一个开关/入口 **/
    private static void switchMethod(CountDownLatch switcher) {
        IntStream.range(0, 3).forEach(r -> new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 线程启动,等待开关开启");
                switcher.await();
                System.out.println(Thread.currentThread().getName() + " 线程执行 start");
                // 模拟执行任务
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " 线程执行 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread_" + r).start());
    }

    /**
     * 作为一个完成信号
     * 将初始计数值为N的 CountDownLatch作为一个完成信号点：使某个线程在其它N个线程完成某项操作之前一直等待。
     *
     * 应用场景: 线程池刷数据,当都执行完的时候发消息可以通过这个来做  order-search 里面刷数据就是这样的
     **/
    private static void finishMethod(int N, CountDownLatch finishSignal) {
        IntStream.range(0, N).forEach(r -> new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 线程执行 start");
                // 模拟执行任务
                TimeUnit.SECONDS.sleep(new Random().nextInt(2 * N));
                System.out.println(Thread.currentThread().getName() + " 线程执行 end, 计数器-1");
                finishSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread_" + r).start());
    }
}
