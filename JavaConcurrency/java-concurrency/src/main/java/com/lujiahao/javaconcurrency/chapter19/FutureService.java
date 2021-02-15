package com.lujiahao.javaconcurrency.chapter19;

public interface FutureService<IN, OUT> {

    /** 提交不需要返回值的任务,Future.get 方法返回的将会是 null **/
    Future<?> submit(Runnable runnable);

    /** 提交需要返回的任务,其中的 Task 接口替代了 runnable 接口 **/
    Future<OUT> submit(Task<IN, OUT> task, IN input);

    /** 使用静态方法创建一个 FutureService 实现 **/
    static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl<>();
    }
}
