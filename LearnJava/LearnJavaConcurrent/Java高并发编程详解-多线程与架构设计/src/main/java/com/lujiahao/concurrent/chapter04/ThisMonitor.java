package com.lujiahao.concurrent.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * this monitor
 * 使用synchronized关键字同步类的不同实例方法,争抢的是同一个monitor的lock
 * 而与之关联的引用则是ThisMonitor的实例引用
 * @author lujiahao
 * @date 2019-11-24
 */
public class ThisMonitor {

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter to method2");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method3() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " enter to method3");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method4() {
        System.out.println(Thread.currentThread().getName() + " enter to method4");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1).start();
        new Thread(thisMonitor::method2).start();
        new Thread(thisMonitor::method3).start();
        new Thread(thisMonitor::method4).start();
    }
}
