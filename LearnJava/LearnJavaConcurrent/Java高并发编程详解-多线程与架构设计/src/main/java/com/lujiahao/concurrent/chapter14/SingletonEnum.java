package com.lujiahao.concurrent.chapter14;

/**
 * 单例 枚举模式
 * @author lujiahao
 * @date 2019-11-28
 */
public class SingletonEnum {
    private SingletonEnum() {
    }

    private enum EnumHolder {
        INSTANCE;

        private SingletonEnum instance;

        EnumHolder() {
            this.instance = new SingletonEnum();
        }

        public SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }
}
