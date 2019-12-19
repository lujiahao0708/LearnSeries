package com.lujiahao.java8inaction.chapter8.observer;

/**
 * @author lujiahao
 * @date 2019-03-18 17:07
 */
public class NYTime implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
