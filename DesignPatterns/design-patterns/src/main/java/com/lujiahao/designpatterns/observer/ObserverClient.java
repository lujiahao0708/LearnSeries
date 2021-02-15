package com.lujiahao.designpatterns.observer;

/**
 * 测试类
 * @author lujiahao
 * @date 2020-09-04
 */
public class ObserverClient {
    public static void main(String[] args) {
        // 创建被观察者
        Subject subject = new ConcreteSubject();
        // 注册观察者 (观察者可以注册多个)
        subject.attach(new ConcreteObserver());
        // 被观察者触发事件
        subject.handleOperation();
    }
}
