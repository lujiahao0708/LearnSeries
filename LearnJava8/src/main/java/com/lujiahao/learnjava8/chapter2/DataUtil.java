package com.lujiahao.learnjava8.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lujiahao
 * @date 2019-02-19 18:33
 */
public class DataUtil {

    public static List<Apple> generateApples() {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 150L));
        appleList.add(new Apple("green", 170L));
        appleList.add(new Apple("yellow", 160L));
        return appleList;
    }
}
