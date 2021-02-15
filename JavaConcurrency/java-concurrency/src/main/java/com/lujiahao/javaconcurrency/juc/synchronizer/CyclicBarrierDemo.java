package com.lujiahao.javaconcurrency.juc.synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 5;
        CyclicBarrier cb = new CyclicBarrier(N,
                // 被最后一个到达的线程执行(await 源码中 doawait 可以看到)
                () -> System.out.println(Thread.currentThread().getName() + " 所有运动员已准备完毕,发令枪:跑!"));

//        normal(N, cb);
        withException(N, cb);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Barrier 是否损坏:" + cb.isBroken());
    }

    private static void normal(int N, CyclicBarrier cb) {
        IntStream.range(0, N).forEach(r -> new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + ": 准备完成");
                // 在栅栏等待
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "Thread_" + r).start());
    }

    private static void withException(int N, CyclicBarrier cb) {
        IntStream.range(0, N).forEach(r -> {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 准备完成");
                    // 在栅栏等待
                    cb.await();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ": 被中断");
                } catch (BrokenBarrierException e) {
                    System.out.println(Thread.currentThread().getName() + ": 抛出BrokenBarrierException");
                }
            }, "Thread_" + r);
            thread.start();
            if (r == 3) {
                thread.interrupt();
            }
        });
    }
}
