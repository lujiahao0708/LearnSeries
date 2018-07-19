package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:from操作符是把其他类型的对象和数据类型转化成Observable,转换集合为一个每次发射集合中一个元素的 Observable 对象。
 * 场景: 遍历集合
 * @author lujiahao
 * @date 2018-07-07 下午9:11
 */
public class FromOperator {
    public static void main(String[] args) {
//        String[] list = new String[]{"a", "b", "c", "d"};
        // 给司机发送抢单通知 或者 多日子单多个司机发送取消通知
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        Observable.from(list).subscribe(new Subscriber<String>() {
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
                System.out.println("onNext:" + s.toString());
            }
        });
    }
}
