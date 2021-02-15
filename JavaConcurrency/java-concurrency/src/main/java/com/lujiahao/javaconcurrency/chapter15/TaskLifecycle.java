package com.lujiahao.javaconcurrency.chapter15;

public interface TaskLifecycle<T> {

    /** 任务启动时触发 **/
    void onStart(Thread thread);

    /** 任务正在运行时触发 **/
    void onRunning(Thread thread);

    /** 任务结束运行时触发,其中 result 是任务执行结束后的结果 **/
    void onFinish(Thread thread, T result);

    /** 任务执行报错时触发 **/
    void onError(Thread thread, Exception e);

    /** 生命周期接口的空实现 Adapter **/
    class EmptyLifecycle<T> implements TaskLifecycle<T> {

        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }
}
