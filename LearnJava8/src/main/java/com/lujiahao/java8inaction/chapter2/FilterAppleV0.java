package com.lujiahao.java8inaction.chapter2;

import com.lujiahao.java8inaction.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 筛选绿色苹果
 * @author lujiahao
 * @date 2019-02-19 18:28
 */
public class FilterAppleV0 {
    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        List<Apple> greenAppleList = new ArrayList<>();

        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                greenAppleList.add(apple);
            }
        }

        System.out.println("原集合:" + appleList);
        System.out.println("绿苹果集合:" + greenAppleList);
    }
}
