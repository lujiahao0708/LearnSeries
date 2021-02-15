package com.lujiahao.javaconcurrency.chapter19;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主要作用在于当提交任务时创建一个新的线程来受理该任务,进而达到任务异步执行的效果
 * @author lujiahao
 * @date 2020-09-04
 */
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {
    // 为执行线程指定名字前缀
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            // 任务执行结束后将 null 作为结果传给 future
            future.finish(null);
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            // 任务执行结束后将 null 作为结果传给 future
            future.finish(result);
        }, getNextName()).start();
        return future;
    }
}
