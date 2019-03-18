package com.lujiahao.learnjava8.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lujiahao
 * @date 2019-03-18 17:08
 */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void nofityObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
