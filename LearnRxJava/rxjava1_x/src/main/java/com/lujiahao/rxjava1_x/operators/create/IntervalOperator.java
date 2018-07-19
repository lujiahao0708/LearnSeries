package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 作用: 返回一个每隔指定的时间间隔就发射一个序列号的 Observable 对象。
 * interval操作符是每隔一段时间就产生一个数字，这些数字从0开始，一次递增1直至无穷大；
 * 场景: 可使用该操作符完成定时、倒计时等功能。
 * @author lujiahao
 * @date 2018-07-08 上午9:39
 */
public class IntervalOperator {
    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("程序开始执行 : " + simpleDateFormat.format(new Date()));
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Long aLong) {
                // 每隔三秒钟发射一个数字,一直发送
                System.out.println(simpleDateFormat.format(new Date()) + " onNext:" + aLong);
            }
        });

        // 需要将程序暂停下来  这样就能看到效果了
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
