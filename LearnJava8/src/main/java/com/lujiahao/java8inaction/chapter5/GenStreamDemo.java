package com.lujiahao.java8inaction.chapter5;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 构建流
 * @author lujiahao
 * @date 2019-03-11 18:05
 */
public class GenStreamDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out::println);

        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}
