package com.lujiahao.concurrent.chapter14;

/**
 * 懒汉式单例
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonLazy {
    private static SingletonLazy instance = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (null == instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
