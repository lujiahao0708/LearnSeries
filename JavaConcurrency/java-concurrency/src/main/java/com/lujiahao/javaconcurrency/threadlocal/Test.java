package com.lujiahao.javaconcurrency.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

public class Test {
    //评测题目: 三个线程，一个打印x，一个打印y，一个打印z，顺序打印，连续打印10次

    /**
     * main方法 * * @param args
     */
    public static void main(String[] args) {
        System.out.println("测评打印");
        useSingleThreadExecutor();
    }

    public static void useJoin() {
        IntStream.range(0, 10).forEach(r -> {
            Thread x = genThread("Thread_x", "X");
            Thread y = genThread("Thread_y", "Y");
            Thread z = genThread("Thread_z", "Z");
            try {
                x.start();
                y.start();
                z.start();
                x.join();
                y.join();
                z.join();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static Thread genThread(String threadName, String printContent) {
        return new Thread(() -> System.out.print(printContent), threadName);
    }

    public static void useLockSupport() {
        IntStream.range(0, 10).forEach(r -> {
            Thread z = new Thread(new Worker(null, "Z"));
            Thread y = new Thread(new Worker(z, "Y"));
            Thread x = new Thread(new Worker(y, "X"));
            x.start();
            y.start();
            z.start();
        });
    }

    static class Worker implements Runnable {
        private Thread nextThread;
        private String printContent;

        public Worker(Thread nextThread, String printContent) {
            this.nextThread = nextThread;
            this.printContent = printContent;
        }

        @Override
        public void run() {
            System.out.print(printContent);
            LockSupport.unpark(nextThread);
        }
    }

    public static void useSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).forEach(r -> {
            singleThreadExecutor.submit(Test.genThread("Thread_x", "X"));
            singleThreadExecutor.submit(Test.genThread("Thread_y", "Y"));
            singleThreadExecutor.submit(Test.genThread("Thread_z", "Z"));
        });

        singleThreadExecutor.shutdown();
    }
}