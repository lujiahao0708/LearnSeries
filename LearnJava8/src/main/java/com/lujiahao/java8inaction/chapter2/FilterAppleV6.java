package com.lujiahao.java8inaction.chapter2;

import com.lujiahao.java8inaction.DataUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List类型抽象话
 *
 * @author lujiahao
 * @date 2019-02-19 18:30
 */
public class FilterAppleV6 {

    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        System.out.println("原集合:" + appleList);

        List<Apple> filterGreenApples = filter(appleList, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println("筛选绿色苹果:" + filterGreenApples);

        System.out.println("=============================================");

        List<Integer> numberList = Arrays.asList(1, 2, 3);
        System.out.println("原集合:" + numberList);

        List<Integer> numbers = filter(numberList, (Integer i) -> i % 2 == 0);
        System.out.println("能被2整除的数:" + numbers);
    }

    /**
     * 筛选绿色苹果
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            // 谓词对象封装了条件
            if (predicate.filter(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }

    public interface Predicate<T> {
        boolean filter(T t);
    }
}
