package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

/**
 * 创建一个不发射任何数据但是正常终止的Observable
 * 执行下面代码,onCompleted方法会被调用
 * @author lujiahao
 * @date 2018-07-07 下午10:34
 */
public class EmptyOperator {
    public static void main(String[] args) {
        Observable<Object> observable = Observable.empty();
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
