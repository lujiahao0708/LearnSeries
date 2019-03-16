package com.lujiahao.learnjava8.chapter2;

import com.lujiahao.learnjava8.DataUtil;

import java.util.Comparator;
import java.util.List;

/**
 * 用 Comparator 排序
 * @author lujiahao
 * @date 2019-03-02 18:34
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Apple> appleList = DataUtil.generateApples();
        System.out.println("原集合:" + appleList);

        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("按重量升序:" + appleList);

        appleList.sort((Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()));
        System.out.println("按颜色字典排序:" + appleList);
    }
}
