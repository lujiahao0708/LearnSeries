package com.lujiahao.java8inaction;

import java.util.function.Supplier;

/**
 * @author lujiahao
 * @date 2019-03-23 22:22
 */
public class Java8Util {

    /**
     * 延迟一秒钟
     */
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计时工具
     * @param supplier
     * @param <T>
     */
    public static <T> void countTime(Supplier<T> supplier) {
        long start = System.nanoTime();
        System.out.println(supplier.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("耗时:Done in " + duration + " msecs");
    }
}
