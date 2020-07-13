package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author lujiahao
 * @date 2019-11-24
 */
public class ThreadExitInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                while (!isInterrupted()) {

                }
                System.out.println("I will be exiting.");
            }
        };

        t.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("System will be shutdown.");
        t.interrupt();
    }
}
