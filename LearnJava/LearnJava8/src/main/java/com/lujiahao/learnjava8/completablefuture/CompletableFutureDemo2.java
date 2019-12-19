package com.lujiahao.learnjava8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lujiahao
 * @date 2019-08-05 10:24
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay(150);
            return Thread.currentThread().getName();
        });

        try {
            String s = completableFuture.get(500, TimeUnit.MILLISECONDS);
            System.out.println("拿到的结果:" + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    public static void delay(long millis) {
        System.out.println("模拟耗时:" + millis);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
