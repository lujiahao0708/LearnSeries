package com.lujiahao.rxjava1_x.demos.zip;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用zip操作符等待多个网络请求完成
 * @author lujiahao
 * @date 2018-07-13 上午11:38
 */
public class ZipTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        Observable getNews = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String newsList = Api.getNewsList();
                    subscriber.onNext(newsList);
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        });

        Observable getBanner = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    String banner = Api.getBanner();
                    subscriber.onNext(banner);
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        });

        Observable.zip(getNews, getBanner, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                System.out.println("拼接两个接口的内容 s:" + s + " s2:" + s2);
                return s + s2;
            }
        }).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("输出内容:" + o);
            }
        });
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
