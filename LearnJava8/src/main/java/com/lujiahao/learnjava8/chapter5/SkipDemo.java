package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-11 16:18
 */
public class SkipDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        List<Dish> dishList = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(dishList);
    }
}
