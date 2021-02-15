package com.lujiahao.javaconcurrency.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> tl = new ThreadLocal<>();

        Thread writeThread = new Thread(() -> tl.set("lujiahao"), "WriteThread");

        Thread readThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = tl.get();
            System.out.println("ThreadLocal get:" + result);
        }, "ReadThread");

        writeThread.start();
        readThread.start();

        writeThread.join();
        readThread.join();
    }
}
