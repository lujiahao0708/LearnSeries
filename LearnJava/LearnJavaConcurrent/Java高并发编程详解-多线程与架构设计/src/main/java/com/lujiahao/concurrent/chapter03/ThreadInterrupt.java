package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * @author lujiahao
 * @date 2019-11-23
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted.");
            }
        });

        thread.start();

        // 短暂休眠保证线程能执行
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
/**
 * 输出结果:
 * Oh, i am be interrupted.
 */
