package com.lujiahao.learnjava8.chapter2;

import com.lujiahao.learnjava8.DataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用匿名类
 * @author lujiahao
 * @date 2019-02-19 18:30
 */
public class FilterAppleV4 {
    
    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        System.out.println("原集合:" + appleList);

        List<Apple> filterGreenApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean filter(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        System.out.println("筛选绿色苹果:" + filterGreenApples);

        List<Apple> filterHeavyApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean filter(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println("筛选重量大于150苹果:" + filterHeavyApples);
    }

    /**
     * 筛选绿色苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate) {
        List<Apple> resultList = new ArrayList<>();
        for (Apple apple : appleList) {
            // 谓词对象封装了条件
            if (predicate.filter(apple)) {
                resultList.add(apple);
            }
        }
        return resultList;
    }

    public interface ApplePredicate {
        boolean filter(Apple apple);
    }
}
