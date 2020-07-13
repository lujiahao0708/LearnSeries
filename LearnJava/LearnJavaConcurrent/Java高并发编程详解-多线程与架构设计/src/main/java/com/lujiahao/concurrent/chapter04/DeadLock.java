package com.lujiahao.concurrent.chapter04;

public class DeadLock {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(()-> {
            while (true) {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + " get lock2");
                    }
                }
            }
        }, "T1").start();

        new Thread(()-> {
            while (true) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + " get lock1");
                    }
                }
            }
        }, "T2").start();
    }
}
