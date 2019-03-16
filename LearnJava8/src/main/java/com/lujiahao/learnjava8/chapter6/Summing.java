package com.lujiahao.learnjava8.chapter6;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 16:20
 */
public class Summing {
    public static void main(String[] args) {
        System.out.println("汇总求和: Collectors.summingInt Collectors.summingDouble Collectors.summingLong");

        Integer collect = DataUtil.genMenu().stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("总热量:" + collect);

        Double collect1 = Arrays.asList(0.1, 0.2, 0.3).stream().collect(Collectors.summingDouble(Double::doubleValue));
        System.out.println("double和:" + collect1);

        Long collect2 = Arrays.asList(1L, 2L, 3L).stream().collect(Collectors.summingLong(Long::longValue));
        System.out.println("long和:" + collect2);
    }
}
