package com.lujiahao.learnjava8.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lujiahao
 * @date 2019-03-08 11:56
 */
public class StreamAndCollection {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8","In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);

    }
}
