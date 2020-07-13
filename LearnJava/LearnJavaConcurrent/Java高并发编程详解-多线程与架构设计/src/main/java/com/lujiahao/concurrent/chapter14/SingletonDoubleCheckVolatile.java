package com.lujiahao.concurrent.chapter14;

/**
 * 单例 double-check+volatile
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonDoubleCheckVolatile {
    private volatile static SingletonDoubleCheckVolatile instance = null;

    private SingletonDoubleCheckVolatile() {
    }

    public static SingletonDoubleCheckVolatile getInstance() {
        if (null == instance) {
            synchronized (SingletonDoubleCheckVolatile.class) {
                if (null == instance) {
                    instance = new SingletonDoubleCheckVolatile();
                }
            }
        }
        return instance;
    }
}
