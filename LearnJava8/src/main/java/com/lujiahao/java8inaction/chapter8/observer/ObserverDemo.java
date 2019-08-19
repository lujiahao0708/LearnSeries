package com.lujiahao.java8inaction.chapter8.observer;

/**
 * @author lujiahao
 * @date 2019-03-18 17:10
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTime());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.nofityObservers("The queen said her favourite book is Java 8 in Action!");

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
    }
}
