package com.lujiahao.java8inaction.chapter5;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 截短流
 * @author lujiahao
 * @date 2019-03-11 16:15
 */
public class LimitDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        List<Dish> list = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
