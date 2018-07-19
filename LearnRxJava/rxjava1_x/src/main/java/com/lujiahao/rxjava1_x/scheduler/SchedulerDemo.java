package com.lujiahao.rxjava1_x.scheduler;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * @author lujiahao
 * @date 2018-07-10 上午10:33
 */
public class SchedulerDemo {
    public static void main(String[] args) {
        Observable.just(1)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Thread:" + Thread.currentThread().getName() + " onNext:" + integer);
                    }
                });
    }
}
