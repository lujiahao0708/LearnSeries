package com.lujiahao.rxjava1_x.observerpattern;

/**
 * @author lujiahao
 * @date 2018-07-06 下午4:43
 */
public class Client {
    public static void main(String[] args) {
        Observable observable = new Observable();
        observable.addObserver(new Observer1());
        observable.addObserver(new Observer2());
        observable.doSomething();
    }
}
