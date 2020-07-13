package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 使用volatile开关控制
 * @author lujiahao
 * @date 2019-11-24
 */
public class ThreadExitFlag {
    static class MyTask extends Thread {
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work.");
            while (!closed && !isInterrupted()) {

            }
            System.out.println("I will be exiting.");
        }

        public void close() {
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("System will be shutdown.");
        t.close();
    }
}
