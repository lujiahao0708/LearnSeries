package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * isInterrupted()
 * Thread成员方法,主要是判断当前线程是否被中断
 * 仅仅是判断interrupt标识,不会对标识产生影响
 *
 * 可中断方法捕获到中断信号后,即捕获InterruptedException异常,
 * 之后会擦除掉interrupt标识
 * @author lujiahao
 * @date 2019-11-23
 */
public class ThreadisInterrupted2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted? %s\n", interrupted());
                    }
                }
            }
        };

        // 将thread线程设置为守护线程,在main线程退出是即退出,从而使JVM中没有非守护线程而自动退出
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        // 这里休眠是为了让tread中断结果先输出,然后在验证interrupt标识的值
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}

/**
 * 输出结果:
 * Thread is interrupted ? false
 * I am be interrupted? false
 * Thread is interrupted ? false
 */
