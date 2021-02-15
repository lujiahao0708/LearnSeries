package com.lujiahao.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * @author lujiahao
 * @date 2020-09-04
 */
public abstract class Subject {
    private List<Observer> observerList = new ArrayList<>();

    /** 注册观察者 **/
    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    /** 移除观察者 **/
    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    /** 通知所有观察者 遍历观察者列表的方式 **/
    protected void notifyObserver() {
        observerList.forEach(Observer::update);
    }

    /** 具体操作,抽象方法,下放到子类中实现 **/
    public abstract void handleOperation();
}
