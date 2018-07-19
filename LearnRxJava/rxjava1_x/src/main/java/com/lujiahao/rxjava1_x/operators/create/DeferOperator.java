package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;

/**
 * 作用: 在订阅的时候才会创建 Observable 对象；每一次订阅都创建一个新的 Observable 对象。
 * 场景: 可以使用该操作符封装需要被多次执行的函数。
 * @author lujiahao
 * @date 2018-07-07 下午10:24
 */
public class DeferOperator {
    public static void main(String[] args) {
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("Hello RxJava defer");
            }
        });

        System.out.println("没看明白为什么是订阅的时候才创建");

        Subscription subscription = observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError:" + throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s);
            }
        });
    }
}
