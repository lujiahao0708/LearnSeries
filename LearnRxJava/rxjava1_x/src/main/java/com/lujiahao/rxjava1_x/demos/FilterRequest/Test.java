package com.lujiahao.rxjava1_x.demos.FilterRequest;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 过滤一定时间内重复的输入源
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0120/7071.html
 *
 * @author lujiahao
 * @date 2018-07-12 下午5:11
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        Observable.from(list)
                .lift(new DistinctWithTimeout<>(
                        24, TimeUnit.HOURS, /*超时时间*/
                        o -> o, /*验证重复的方法*/
                        Schedulers.io(),/*处理此操作符的线程池*/
                        new Action1<Object>() {
                            @Override
                            public void call(Object s) {
                                /*如果重复,返回的错误消息*/
                                System.out.println("重复,返回错误信息, 返回数据:" + s);
                            }
                        }
                ))
                .map(new Func1<Object, Object>() {
                    @Override
                    public Object call(Object o) {
                        return converData(o);
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object integer) {
                        System.out.println("正常:" + integer + ",开始执行后续操作");
                    }
                });
    }

    private static Object converData(Object o) {
        int t = (int)o;
        if (t % 2 == 0) {
            t = t + 100;
        } else {
            t = t + 200;
        }
        System.out.println("原始数据:" + o + "  处理后数据:" + t);
        return t;
    }
}
