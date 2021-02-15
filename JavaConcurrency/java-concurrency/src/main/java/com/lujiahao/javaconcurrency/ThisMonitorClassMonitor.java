package com.lujiahao.javaconcurrency;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThisMonitorClassMonitor {
    public synchronized void normalMethod() {
        try {
            System.out.println("normal method");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticMethod() {
        try {
            System.out.println("static method");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitorClassMonitor test = new ThisMonitorClassMonitor();
        new Thread(test::normalMethod, "T1").start();
        new Thread(ThisMonitorClassMonitor::staticMethod, "T2").start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("Hook thread start");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}
