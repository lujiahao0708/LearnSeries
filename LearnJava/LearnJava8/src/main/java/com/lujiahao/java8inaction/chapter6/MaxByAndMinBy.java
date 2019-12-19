package com.lujiahao.java8inaction.chapter6;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 16:14
 */
public class MaxByAndMinBy {
    public static void main(String[] args) {
        System.out.println("找出热量最高的食物:");
        Optional<Dish> collect = DataUtil.genMenu().stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)));
        collect.ifPresent(System.out::println);

        System.out.println("找出热量最低的食物:");
        Optional<Dish> collect1 = DataUtil.genMenu().stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)));
        collect1.ifPresent(System.out::println);
    }
}
