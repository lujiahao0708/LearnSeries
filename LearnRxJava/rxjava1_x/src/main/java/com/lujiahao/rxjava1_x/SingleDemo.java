package com.lujiahao.rxjava1_x;

import rx.Single;
import rx.SingleSubscriber;

/**
 * @author lujiahao
 * @date 2018-07-07 下午9:52
 */
public class SingleDemo {
    public static void main(String[] args) {
//        Single.from()
        // todo 说是只能发射一个值  一会尝试一下发送多个
        Single.create(new Single.OnSubscribe<String>() {
            @Override
            public void call(SingleSubscriber<? super String> singleSubscriber) {
                for (int i = 0; i < 3; i++) {
                    singleSubscriber.onSuccess("Hello RxJava single1!");
                    singleSubscriber.onSuccess("Hello RxJava single2!");
                }
            }
        }).subscribe(new SingleSubscriber<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("onSuccess:" + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError:" + throwable.getMessage());
            }
        });
    }
}
