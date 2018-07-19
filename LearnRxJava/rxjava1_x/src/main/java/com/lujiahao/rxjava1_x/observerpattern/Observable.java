package com.lujiahao.rxjava1_x.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lujiahao
 * @date 2018-07-06 下午4:36
 */
public class Observable {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void doSomething() {
        System.out.println("我是被观察者，我发生变化了");
        // 主动去通知所有的观察者
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}