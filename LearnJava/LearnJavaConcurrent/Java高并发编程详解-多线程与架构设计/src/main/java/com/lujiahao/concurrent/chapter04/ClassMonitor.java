package com.lujiahao.concurrent.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * class monitor
 * 使用synchronized同步类的不同静态方法,争抢的是同一个monitor的lock
 * 而与之关联的是类(ClassMonitor.class)的实例
 * @author lujiahao
 * @date 2019-11-24
 */
public class ClassMonitor {

    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter to method2");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method3() {
        synchronized (ClassMonitor.class) {
            System.out.println(Thread.currentThread().getName() + " enter to method3");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(ClassMonitor::method1).start();
        new Thread(ClassMonitor::method2).start();
        new Thread(ClassMonitor::method3).start();
    }
}
