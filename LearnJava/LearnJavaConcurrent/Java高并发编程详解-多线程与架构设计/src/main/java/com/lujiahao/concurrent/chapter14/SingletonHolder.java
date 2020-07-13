package com.lujiahao.concurrent.chapter14;

/**
 * 单例 Holder
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonHolder {
    private SingletonHolder() {
    }

    private static class Holder {
        private static SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        // SingletonHolder类初始化不会创建SingletonHolder实例(即instance)
        // 只有当Holder类被主动引用的时候才会创建SingletonHolder实例
        return Holder.instance;
    }
}
