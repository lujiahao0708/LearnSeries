package com.lujiahao.learnjava8.chapter6;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 16:38
 */
public class Summarizing {
    public static void main(String[] args) {
        IntSummaryStatistics collect = DataUtil.genMenu().stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("int:" + collect);

        DoubleSummaryStatistics collect1 = Arrays.asList(0.1, 0.2, 0.3).stream().collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("double:" + collect1);

        LongSummaryStatistics collect2 = Arrays.asList(1L, 2L, 3L).stream().collect(Collectors.summarizingLong(Long::longValue));
        System.out.println("long:" + collect2);
    }
}
