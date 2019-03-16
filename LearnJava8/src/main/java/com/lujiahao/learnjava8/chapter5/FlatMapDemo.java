package com.lujiahao.learnjava8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流的扁平化
 * @author lujiahao
 * @date 2019-03-11 16:36
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<String> list = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> list1 = numbers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
