package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * isInterrupted()
 * Thread成员方法,主要是判断当前线程是否被中断
 * 仅仅是判断interrupt标识,不会对标识产生影响
 * @author lujiahao
 * @date 2019-11-23
 */
public class ThreadisInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    // 死循环
                }
            }
        };

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
/**
 * 输出结果:
 * Thread is interrupted ? false
 * Thread is interrupted ? true
 */
