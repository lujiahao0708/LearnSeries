package com.lujiahao.javaconcurrency.chapter19;

import java.util.concurrent.TimeUnit;

public class FutureClient {
    public static void main(String[] args) throws InterruptedException {
        // 定义不需要返回值的 FutureService
        FutureService<Void,Void> service = FutureService.newService();
        // submit 方法为立即返回的方法
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am finish done");
        });
        // get 方法会使当前线程进入阻塞
        future.get();
    }
}
