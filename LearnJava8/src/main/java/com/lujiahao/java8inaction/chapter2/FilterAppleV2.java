package com.lujiahao.java8inaction.chapter2;

import com.lujiahao.java8inaction.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要判断的属性作为参数传入
 * @author lujiahao
 * @date 2019-02-19 18:30
 */
public class FilterAppleV2 {

    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        System.out.println("原集合:" + appleList);

        List<Apple> filterGreenApples = filterApples(appleList, "green");
        System.out.println("筛选绿色苹果:" + filterGreenApples);

        List<Apple> filterRedApples = filterApples(appleList, "red");
        System.out.println("筛选红色苹果:" + filterRedApples);
    }

    /**
     * 筛选特定颜色苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterApples(List<Apple> appleList, String color) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple : appleList) {
            if (color.equals(apple.getColor())) {
                resultList.add(apple);
            }
        }
        return resultList;
    }
}
