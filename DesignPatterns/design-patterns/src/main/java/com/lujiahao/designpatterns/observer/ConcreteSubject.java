package com.lujiahao.designpatterns.observer;

/**
 * 具体的被观察者
 * @author lujiahao
 * @date 2020-09-04
 */
public class ConcreteSubject extends Subject {

    /** 具体的被观察者中执行具体操作,随后会通知到所有的观察者 **/
    @Override
    public void handleOperation() {
        System.out.println("被观察者执行具体动作,即将通知所有观察者");
        this.notifyObserver();
    }
}
