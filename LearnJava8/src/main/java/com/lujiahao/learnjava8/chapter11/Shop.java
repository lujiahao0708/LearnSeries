package com.lujiahao.learnjava8.chapter11;

import com.lujiahao.learnjava8.Java8Util;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author lujiahao
 * @date 2019-03-23 17:40
 */
public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 同步方法
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 异步方法
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                //
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    /**
     * 异步方法(使用工厂方法)
     */
    public Future<Double> getPriceAsyncBySupplyAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 计算价格方法(调用了延迟一秒方法,模拟耗时操作)
     */
    private double calculatePrice(String product) {
        Java8Util.delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
