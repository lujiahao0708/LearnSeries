package com.lujiahao.java8inaction.chapter6;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-14 17:55
 */
public class Demo1 {
    public static void main(String[] args) {
        Long collect = DataUtil.genMenu().stream().collect(Collectors.counting());
        System.out.println(collect);

        long count = DataUtil.genMenu().stream().count();
        System.out.println(count);

        // 查找流中最大值 Collectors.maxBy()
        Optional<Dish> collect1 = DataUtil.genMenu().stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        collect1.ifPresent(System.out::println);

        // 查找流中最小值 Collectors.minBy()
        Optional<Dish> collect2 = DataUtil.genMenu().stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        collect2.ifPresent(System.out::println);


        IntSummaryStatistics intSummaryStatistics = DataUtil.genMenu().stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getCount());

        String collect3 = DataUtil.genMenu().stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(collect3);

        String collect4 = DataUtil.genMenu().stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect4);

        Integer collect5 = DataUtil.genMenu().stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(collect5);

        Integer collect6 = DataUtil.genMenu().stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect6);
    }
}
