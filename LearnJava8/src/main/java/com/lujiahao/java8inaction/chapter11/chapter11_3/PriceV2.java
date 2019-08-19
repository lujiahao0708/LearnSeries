package com.lujiahao.java8inaction.chapter11.chapter11_3;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.Java8Util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * 使用定制执行器
 * @author lujiahao
 * @date 2019-03-23 18:33
 */
public class PriceV2 {
    public static void main(String[] args) {
        String product = "myPhone27S";
        System.out.println("顺序同步请求---------------------------------------------");
        Java8Util.countTime(() -> findPrices(product));

        System.out.println("\n使用并行流对请求进行并行操作---------------------------------------------");
        Java8Util.countTime(() -> findPricesByParallelStream(product));

        System.out.println("\n使用CompletableFuture发起异步请求---------------------------------------------");
        Java8Util.countTime(() -> findPricesByCompletableFuture(product));

        System.out.println("\n使用CompletableFuture发起异步请求WithExecutor---------------------------------------------");
        Java8Util.countTime(() -> findPricesByCompletableFutureWithExecutor(product));
    }

    /**
     * 顺序同步请求
     * 查询是顺序进行的，并且一个查询操作会阻塞另一个
     */
    public static List<String> findPrices(String product) {
        return DataUtil.getShops().stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 使用并行流对请求进行并行操作
     * 不同商店的查询实现了并行
     */
    public static List<String> findPricesByParallelStream(String product) {
        return DataUtil.getShops().parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 使用CompletableFuture发起异步请求
     */
    public static List<String> findPricesByCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = DataUtil.getShops().stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(product))
                )
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)   // 等待所有异步操作结束
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

    /**
     * 使用CompletableFuture发起异步请求WithExecutor
     */
    public static List<String> findPricesByCompletableFutureWithExecutor(String product) {
        List<CompletableFuture<String>> priceFutures = DataUtil.getShops().stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(product), executor)
                )
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
