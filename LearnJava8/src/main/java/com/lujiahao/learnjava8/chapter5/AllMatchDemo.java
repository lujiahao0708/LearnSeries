package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019-03-11 16:51
 */
public class AllMatchDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        boolean b = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(b);
    }
}
