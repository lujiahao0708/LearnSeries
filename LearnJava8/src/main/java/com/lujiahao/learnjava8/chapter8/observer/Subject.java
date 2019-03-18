package com.lujiahao.learnjava8.chapter8.observer;

/**
 * @author lujiahao
 * @date 2019-03-18 17:08
 */
public interface Subject {
    void registerObserver(Observer o);
    void nofityObservers(String tweet);
}
