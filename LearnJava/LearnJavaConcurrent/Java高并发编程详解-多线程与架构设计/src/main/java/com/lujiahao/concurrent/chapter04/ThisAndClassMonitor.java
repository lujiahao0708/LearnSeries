package com.lujiahao.concurrent.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * method1是ThisAndClassMonitor实例的锁
 * method2是ThisAndClassMonitor.class 类的锁
 * @author lujiahao
 * @date 2019-11-24
 */
public class ThisAndClassMonitor {

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish method1");
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter to method2");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish method2");
    }

    public static void main(String[] args) {
        ThisAndClassMonitor monitor = new ThisAndClassMonitor();
        new Thread(monitor::method1).start();
        new Thread(ThisAndClassMonitor::method2).start();
    }
}

/**
 * 输出结果:
 * Thread-0 enter to method1
 * Thread-1 enter to method2
 * Thread-0 finish method1
 * Thread-1 finish method2
 */
