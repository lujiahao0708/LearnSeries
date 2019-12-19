package com.lujiahao.java8inaction.chapter5;

import com.lujiahao.java8inaction.DataUtil;
import com.lujiahao.java8inaction.chapter4.Dish;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019-03-11 16:53
 */
public class NoneMatchDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        boolean b = menu.stream().noneMatch(d -> d.getCalories() > 1000);
        System.out.println(b);
    }
}
