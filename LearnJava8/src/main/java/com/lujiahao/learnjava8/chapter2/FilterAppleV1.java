package com.lujiahao.learnjava8.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 筛选绿色苹果
 * @author lujiahao
 * @date 2019-02-19 18:30
 */
public class FilterAppleV1 {

    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        System.out.println("原集合:" + appleList);

        List<Apple> filterGreenApples = filterGreenApples(appleList);
        System.out.println("绿苹果集合:" + filterGreenApples);
    }

    /**
     * 筛选绿色苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> appleList) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                resultList.add(apple);
            }
        }
        return resultList;
    }
}
