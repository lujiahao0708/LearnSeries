package com.lujiahao.designpatterns.observer;

/**
 * 具体的观察者
 * @author lujiahao
 * @date 2020-09-04
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("观察者收到信息,进行处理");
    }
}
