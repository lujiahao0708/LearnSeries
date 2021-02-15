package com.lujiahao.javaconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is interrupted?" + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted?" + Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
            System.out.println("I will be interrupted still.");
        }
        /*输出结果:
        Main thread is interrupted?false
        Main thread is interrupted?true
        I will be interrupted still.*/
    }
}
