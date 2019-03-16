package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author lujiahao
 * @date 2019-03-11 16:57
 */
public class FindAnyDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        Optional<Dish> any = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        any.ifPresent(d -> System.out.println(d.getName()));
    }
}
