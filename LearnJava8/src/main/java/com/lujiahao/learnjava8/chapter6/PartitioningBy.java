package com.lujiahao.learnjava8.chapter6;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 17:30
 */
public class PartitioningBy {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> collect = DataUtil.genMenu().stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect.get(true));

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect1 = DataUtil.genMenu().stream().collect(Collectors.partitioningBy(
                Dish::isVegetarian, Collectors.groupingBy(Dish::getType)
        ));
        System.out.println(collect1);
    }
}
