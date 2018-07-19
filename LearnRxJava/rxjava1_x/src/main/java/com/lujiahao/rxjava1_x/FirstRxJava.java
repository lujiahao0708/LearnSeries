package com.lujiahao.rxjava1_x;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author lujiahao
 * @date 2018-07-06 下午3:40
 */
public class FirstRxJava {
    public static void main(String[] args) {
        first();
//        second();
//        third();
//        four();
//        five();
    }
    public static void first() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                // 发送一个事件
                subscriber.onNext("Hello RxJava!");
                // 事件发送完成
                subscriber.onCompleted();
            }
        });
        // Observable 发出了一个类型为 String ，值为 “Hello World!” 的事件

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s);
            }
        };

        observable.subscribe(observer);
    }

    public static void second() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava!");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s);
            }
        });
    }

    public static void third() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("Hello RxJava!");
            subscriber.onCompleted();
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s);
            }
        });
    }

    public static void four() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("Hello RxJava!");
            subscriber.onCompleted();
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("call:" + s);
            }
        });
    }

    public static void five() {
        Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("Hello RxJava!");
            subscriber.onCompleted();
        }).subscribe(s -> System.out.println("call:" + s));
    }
}
