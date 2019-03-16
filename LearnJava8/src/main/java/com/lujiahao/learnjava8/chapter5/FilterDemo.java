package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;
import com.lujiahao.learnjava8.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用谓词筛选
 * @author lujiahao
 * @date 2019-03-11 16:07
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        List<Dish> vegetarianList = menu.stream().filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegetarianList);
    }
}
