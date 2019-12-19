package com.lujiahao.java8inaction.chapter5;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对流中每一个元素应用函数
 * @author lujiahao
 * @date 2019-03-11 16:30
 */
public class MapDemo {
    public static void main(String[] args) {
        List<String> dishNames = DataUtil.genMenu().stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> list = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
