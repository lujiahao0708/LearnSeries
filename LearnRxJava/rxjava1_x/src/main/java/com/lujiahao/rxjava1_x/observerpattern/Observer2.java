package com.lujiahao.rxjava1_x.observerpattern;

/**
 * @author lujiahao
 * @date 2018-07-06 下午4:43
 */
public class Observer2 implements Observer {
    @Override
    public void update(Observable observable) {
        System.out.println("观察者2观察到" + observable.getClass().getSimpleName() + "发生变化,观察者2做出响应");
    }
}
