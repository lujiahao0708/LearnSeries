package com.lujiahao.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * interrupt注意事项
 * 如果线程在没有执行可中断方法之前就被打断,是否会执行中断方法
 * @author lujiahao
 * @date 2019-11-23
 */
public class ThreadInterruptAttention {

    public static void main(String[] args) {
        // 判断当前线程是否被中断(此方法执行会直接擦除掉线程的interrupt标识)
        System.out.println("Main thread is interrupted? " + Thread.interrupted());

        // 中断当前线程(此方法执行会将线程的interrupt标识设置为true)
        Thread.currentThread().interrupt();

        // 判断当前线程是否已经被中断(此方法不会改变线程的interrupt标识)
        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

        try {
            // 当前线程中执行可中断方法
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            // 捕获中断信号
            System.out.println("I will be interrupted still.");
        }
    }
}
/**
 * 运行结果:
 * Main thread is interrupted? false
 * Main thread is interrupted? true
 * I will be interrupted still.
 *
 * 原因解释:如果一个线程设置了interrupt标识,那么中断方法会立即中断,因此信号捕获部分内容会被执行
 */
