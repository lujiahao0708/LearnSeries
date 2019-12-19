package com.lujiahao.java8inaction.chapter6;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-16 16:44
 */
public class Joining {
    public static void main(String[] args) {
        String collect = DataUtil.genMenu().stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(collect);

        String collect1 = DataUtil.genMenu().stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect1);
    }
}
