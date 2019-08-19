package com.lujiahao.java8inaction.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * 筛选各异的元素(去重)
 * @author lujiahao
 * @date 2019-03-11 16:09
 */
public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
