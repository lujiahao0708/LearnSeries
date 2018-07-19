package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

/**
 * 创建一个不发射数据以一个错误终止的Observable
 * onError方法会被调用
 * @author lujiahao
 * @date 2018-07-07 下午10:39
 */
public class ErrorOperator {
    public static void main(String[] args) {
        Observable<Object> observable = Observable.error(new Throwable("exception show"));
        observable.subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Object s) {
                System.out.println("onNext:" + s.toString());
            }
        });
    }
}
