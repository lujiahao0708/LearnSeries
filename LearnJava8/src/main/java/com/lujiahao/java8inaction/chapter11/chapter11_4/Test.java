package com.lujiahao.java8inaction.chapter11.chapter11_4;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.Java8Util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-23 22:16
 */
public class Test {
    public static void main(String[] args) {
        Java8Util.countTime(() -> findPrice("test"));
        Java8Util.countTime(() -> findPricesByCompletableFuture("test"));
    }

    public static List<String> findPrice(String product) {
        return DataUtil.getShop11_4().stream()
                .map(shop11_4 -> shop11_4.getPrice(product))
                .map(str -> Quote.parse(str))
                .map(quote -> Discount.applyDiscount(quote))
                .collect(Collectors.toList());
    }

    private static final Executor executor = Executors.newFixedThreadPool(Math.min(DataUtil.getShops().size(), 100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
            });

    public static List<String> findPricesByCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFuture = DataUtil.getShop11_4().stream()
                .map(shop11_4 -> CompletableFuture.supplyAsync(
                        () -> shop11_4.getPrice(product), executor
                ))
                .map(future -> future.thenApply(str -> Quote.parse(str)))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor
                )))
                .collect(Collectors.toList());
        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
