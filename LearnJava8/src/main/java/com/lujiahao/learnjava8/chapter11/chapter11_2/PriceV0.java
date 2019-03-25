package com.lujiahao.learnjava8.chapter11.chapter11_2;

import com.lujiahao.learnjava8.chapter11.Shop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 价格查询 异步实现
 *
 * @author lujiahao
 * @date 2019-03-23 17:39
 */
public class PriceV0 {
    public static void main(String[] args) {
        getPriceSync();
        System.out.println("------------------------------");
        getPriceAsync();
        System.out.println("------------------------------");
        getPriceAsyncBySupplyAsync();
    }

    /**
     * 同步方法
     */
    public static void getPriceSync() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        double price = shop.getPrice("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        System.out.println("doSomethingElse...");

        System.out.printf("Price is %.2f%n", price);

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    /**
     * 异步方法
     */
    public static void getPriceAsync() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        System.out.println("doSomethingElse...");

        try {
            // 通过get方法获取值
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    /**
     * 异步方法
     */
    public static void getPriceAsyncBySupplyAsync() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsyncBySupplyAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        System.out.println("doSomethingElse...");

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
