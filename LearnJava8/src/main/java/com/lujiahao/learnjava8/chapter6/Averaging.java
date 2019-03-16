package com.lujiahao.learnjava8.chapter6;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 16:28
 */
public class Averaging {
    public static void main(String[] args) {
        System.out.println("汇总求平均值: Collectors.averagingInt Collectors.averagingLong Collectors.averagingDouble");

        Double collect = DataUtil.genMenu().stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("平均热量:" + collect);

        Double collect1 = Arrays.asList(0.1, 0.2, 0.3).stream().collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println("double 平均值:" + collect1);

        Double collect2 = Arrays.asList(1L, 2L, 3L).stream().collect(Collectors.averagingLong(Long::longValue));
        System.out.println("long 平均值:" + collect2);
    }
}
