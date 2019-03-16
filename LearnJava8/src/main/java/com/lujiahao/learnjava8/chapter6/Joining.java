package com.lujiahao.learnjava8.chapter6;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

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
