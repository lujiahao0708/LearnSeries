package com.lujiahao.concurrent.chapter14;

/**
 * 饿汉式+同步方法
 * 性能低下
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonHungarySync {
    private static SingletonHungarySync instance = null;

    private SingletonHungarySync() {
    }

    public synchronized static SingletonHungarySync getInstance() {
        if (null == instance) {
            instance = new SingletonHungarySync();
        }
        return instance;
    }
}
