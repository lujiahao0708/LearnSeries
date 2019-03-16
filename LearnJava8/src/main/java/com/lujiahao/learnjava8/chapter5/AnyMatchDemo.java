package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019-03-11 16:47
 */
public class AnyMatchDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("vegetarian");
        }
    }
}
