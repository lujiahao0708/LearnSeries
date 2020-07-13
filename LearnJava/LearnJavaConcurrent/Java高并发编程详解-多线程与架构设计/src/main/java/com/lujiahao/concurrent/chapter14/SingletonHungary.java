package com.lujiahao.concurrent.chapter14;

/**
 * 饿汉式单例
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonHungary {
    private static SingletonHungary instance = new SingletonHungary();

    private SingletonHungary() {
    }

    public static SingletonHungary getInstance() {
        return instance;
    }
}
