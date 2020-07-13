package com.lujiahao.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * 同一个线程两次调用start方法
 * @author lujiahao
 * @date 2019-11-20
 */
public class ThreadDoubleStart2 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // 第一次调用start方法,启动线程
        thread.start();

        try {
            // main线程休眠保证上面thread线程生命周期已结束
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 第二次调用start方法,企图重新激活该线程
        thread.start();
    }
}

/**
 * 输出结果:
 * Exception in thread "main" java.lang.IllegalThreadStateException
 * 	at java.lang.Thread.start(Thread.java:708)
 * 	at com.lujiahao.concurrent.chapter01.ThreadDoubleStart.main(ThreadDoubleStart.java:27)
 *
 * 本次异常的根本原因是:
 *  thread线程已经执行完毕,生命周期已经结束,再次调用start方法将会跑出非法状态异常
 *
 * 进入Thread源码查看:
 * if (threadStatus != 0)
 *             throw new IllegalThreadStateException();
 */
