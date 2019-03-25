package com.lujiahao.learnjava8.chapter11.chapter11_1;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lujiahao
 * @date 2019-03-23 11:48
 */
public class FutureDemo {
    public static void main(String[] args) {
        // 创建ExecutorService 向线程池提交任务
        ExecutorService executor = Executors.newCachedThreadPool();
        // 提交Callable对象
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                // 以异步方式在新的线程中执行耗时操作
                return doSomeLongComputation();
            }
        });
        // 异步操作进行的同时,可以做其他事情
        doSomethingElse();

        try {
            // 获取异步操作的结果,如果最终被阻塞,无法得到结果,那么最多等待1s后退出
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.err.println("计算抛出一个异常");
        }catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("当前线程在等待过程中被中断");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.err.println("Future对象完成之前已过期");
        }
    }

    private static void doSomethingElse() {
        System.out.println("异步操作进行的同时,可以做其他事情");
    }

    private static Double doSomeLongComputation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (new Random()).nextDouble();
    }
}
