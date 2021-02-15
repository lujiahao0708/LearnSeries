package com.lujiahao.javaconcurrency.chapter15;

public interface Observable {
    /** 任务生命周期枚举 **/
    enum Cycle{
        STARTED, RUNNING, DONE, ERROR
    }

    /** 获取当前任务的生命周期状态 **/
    Cycle getCycle();

    /** 定义启动线程的方法,主要是屏蔽 Thread 的其他方法 **/
    void start();

    /** 定义线程的打断方法,屏蔽 Thread 的其他方法 **/
    void interrupt();
}
