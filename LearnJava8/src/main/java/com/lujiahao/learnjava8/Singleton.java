package com.lujiahao.learnjava8;

/**
 * @author lujiahao
 * @date 2018-12-17 17:11
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
