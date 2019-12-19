package com.lujiahao.java8inaction.chapter6;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 17:07
 */
public class GroupingBy {
    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> collect = DataUtil.genMenu().stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect1 = DataUtil.genMenu().stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else return CaloricLevel.FAT;
                        }))
        );
        System.out.println(collect1);

        Map<Dish.Type, Long> collect2 = DataUtil.genMenu().stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect2);

        Map<Dish.Type, Dish> collect3 = DataUtil.genMenu().stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get
                )));
        System.out.println(collect3);

        Map<Dish.Type, Set<CaloricLevel>> collect4 = DataUtil.genMenu().stream().collect(Collectors.groupingBy(
                Dish::getType, Collectors.mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else return CaloricLevel.FAT;
                        }, Collectors.toSet()
                )
        ));
        System.out.println(collect4);
    }
}
