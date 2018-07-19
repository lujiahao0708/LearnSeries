package com.lujiahao.rxjava1_x.operators.create;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用: 创建一个发射指定范围内的连续整数的 Observable 对象。
 *      一个是范围的起始值，一个是范围的数据的数目。如果你将第二个参数设为0，将导致Observable不发射任何数据（如果设置为负数，会抛异常）。
 * 场景: 可使用该操作符完成一个 for 的循环，
 * 如: for(int i=5;i<=7;i++) -> Observable.range(5, 3)
 *
 * @author lujiahao
 * @date 2018-07-08 上午10:03
 */
public class RangeOperator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Observable.range(0, list.size()).subscribe(new Subscriber<Integer>() {
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
                System.out.println("onNext:" + integer);
            }
        });

        System.out.println("===================");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
