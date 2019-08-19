package com.lujiahao.java8inaction.chapter5;

import java.util.stream.IntStream;

/**
 * @author lujiahao
 * @date 2019-03-11 17:52
 */
public class IntStreamDemo {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream.count());

        IntStream intStream1 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream1.count());
    }
}
