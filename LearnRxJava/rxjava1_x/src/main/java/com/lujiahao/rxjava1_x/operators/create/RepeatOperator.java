package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Observer;

/**
 * @author lujiahao
 * @date 2018-07-08 上午10:13
 */
public class RepeatOperator {
    public static void main(String[] args) {
        String[] names = {"java", "c++", "lisp", "python"};
        Observable observable = Observable.just(names).repeat(2);
//        observable.repeat(5); 不起作用,....
        observable.subscribe(new Observer<String []>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String [] names) {
                for (String str: names) {
                    System.out.println("onNext:" + str);
                }
            }
        });
    }
}
