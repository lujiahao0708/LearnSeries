package com.lujiahao.rxjava1_x.demos.DataConvert;

import rx.Observable;

/**
 * 复杂的数据变换
 * @author lujiahao
 * @date 2018-07-12 下午7:44
 */
public class DataConvert {
    public static void main(String[] args) {
        Observable.just("1", "2", "2", "3", "4", "5")
                .map(s -> Integer.parseInt(s))
                .filter(s -> s > 1)
                .distinct()
                .take(3)
                .reduce((integer, integer2) -> integer.intValue() + integer2.intValue())
                .subscribe(System.out::println);
    }
}


/**
 * map      转化
 * filter   过滤
 * distinct 过滤重复
 * take     选取三个元素
 * reduce   循环执行
 * 最后输出9
 */
