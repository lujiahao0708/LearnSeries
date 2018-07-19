package com.lujiahao.rxjava1_x.operators.create;


import rx.Observable;
import rx.Subscriber;

/**
 * 作用: 返回一个在被 OnSubscribe 订阅时执行特定方法的 Observable 对象，
 * 场景: 不推荐使用，可使用其他操作符替代，如使用 from()操作符完成遍历。
 * @author lujiahao
 * @date 2018-07-07 下午6:15
 */
public class CreateOperator {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("Hello RxJava CreateOperator!");
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
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
}
