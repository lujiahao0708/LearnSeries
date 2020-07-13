package com.lujiahao.concurrent.chapter14;

/**
 * 单例 double check模式
 * 可能会由于指令重排序和happen-before原则导致空指针
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonDoubleCheck {
    private static SingletonDoubleCheck instance = null;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (null == instance) {
            synchronized (SingletonDoubleCheck.class) {
                if (null == instance) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
