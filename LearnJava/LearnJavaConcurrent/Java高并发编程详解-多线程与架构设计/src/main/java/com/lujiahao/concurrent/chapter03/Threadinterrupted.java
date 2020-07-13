package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * interrupted() 静态方法
 * 用于判断当前线程是否被中断
 * 该方法会直接擦除掉线程的interrupt标识
 * @author lujiahao
 * @date 2019-11-23
 */
public class Threadinterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        // 短暂停顿保证线程执行
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
/**
 * 输出结果:
 * false
 * false
 * false
 * false
 * true
 * false
 * false
 * false
 * false
 */
