package com.lujiahao.concurrent.chapter09;

/**
 * 类的主动使用和被动使用的几种情况
 * @author lujiahao
 * @date 2019-11-26
 */
public class LoadClass {
    public static void main(String[] args) {
        initByNew();
    }

    private static void initByNew() {
        System.out.println("1.通过new关键字导致类的初始化");
        new Simple();
    }
}
