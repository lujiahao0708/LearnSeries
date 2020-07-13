package com.lujiahao.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * 同一个线程两次调用start方法
 * @author lujiahao
 * @date 2019-11-20
 */
public class ThreadDoubleStart {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // 第一次调用start方法,启动线程
        thread.start();

        // 第二次调用start方法
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
 *  thread线程已经启动,其threadStatus已经不等于0了,线程已经处于运行状态,是不允许再次启动的
 *  再次调用start方法将会抛出非法状态异常
 *
 * 进入Thread源码查看:
 * if (threadStatus != 0)
 *             throw new IllegalThreadStateException();
 */
