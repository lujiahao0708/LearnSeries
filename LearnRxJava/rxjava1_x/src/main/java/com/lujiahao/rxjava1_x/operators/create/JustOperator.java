package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:
 * just操作符也是把其他类型的对象和数据类型转化成Observable，它和from操作符很像，只是方法的参数有所差别
 * 转换一个或多个 Object 为依次发射这些 Object 的 Observable 对象。
 *
 * 场景：转换一个或多个普通 Object 为 Observable 对象，如转换数据库查询结果、网络查询结果等。
 *
 * 特点：所有Observer一旦订阅这个Observable就会立即调用onNext()方法并传入Observable.just()的参数，
 * 而后因为Observable没有数据可以发送了，onComplete()方法会被调用。使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据
 *
 * 注意: just() 方法可传入 1~10 个参数，也就说当元素个数小于等于 10 的时候既可以使用just() 也可以使用 from()，否则只能用 from() 方法。
 * @author lujiahao
 * @date 2018-07-07 下午9:07
 */
public class JustOperator {
    public static void main(String[] args) {
        String[] list = new String[]{"a", "b", "c", "d"};
        Observable.just(list).subscribe(new Subscriber<String[]>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String[] strings) {
                for (int i = 0; i < strings.length; i++) {
                    System.out.println("onNext:" + strings[i]);
                }
            }
        });
        System.out.println("===========================================");
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list1.add("" + i);
        }
        Observable.just(list1).subscribe(new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(List<String> strings) {
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println("onNext:" + strings.get(i));
                }
            }
        });
    }
}
