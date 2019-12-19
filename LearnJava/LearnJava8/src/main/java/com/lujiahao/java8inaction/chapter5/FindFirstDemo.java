package com.lujiahao.java8inaction.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * @author lujiahao
 * @date 2019-03-11 17:02
 */
public class FindFirstDemo {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5);
        number.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst()
                .ifPresent(i -> System.out.println(i));
    }
}
