package com.lujiahao.concurrent.chapter08;

/**
 * 拒绝策略接口
 * 当RunableQueue中runable数量达到limit上限时,采用何种策略通知提交者
 * @author lujiahao
 * @date 2019-11-26
 */
@FunctionalInterface
public interface DenyPolicy {

    /**
     * 拒绝方法
     */
    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 该策略会直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            // do nothing
        }
    }

    /**
     * 该策略会向任务提交者抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnable " + runnable + " will be abord.");
        }
    }

    /**
     * 该策略会使任务在提交者所在的线程中执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}
