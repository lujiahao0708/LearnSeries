package com.lujiahao.learnjava8.completablefuture;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author lujiahao
 * @date 2019-07-31 11:56
 */
public class CompletableFutureDemo1 {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            double value = get();
            future.complete(value);
        }).start();

        System.out.println("--- no block ---");

        future.whenComplete((v, e) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(e).ifPresent(ee -> ee.printStackTrace());
        });
    }

    private static double get() {
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RANDOM.nextDouble();
    }
}
