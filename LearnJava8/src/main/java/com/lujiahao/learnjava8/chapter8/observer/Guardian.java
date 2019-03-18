package com.lujiahao.learnjava8.chapter8.observer;

/**
 * @author lujiahao
 * @date 2019-03-18 17:07
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
