package com.lujiahao.learnjava8.chapter4;

import com.lujiahao.learnjava8.DataUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-08 11:46
 */
public class DishDemo {
    public static void main(String[] args) {
        List<Dish> menu = DataUtil.genMenu();
        List<String> lowCaloricDishesNameList = getLowCaloricDishesNameList(menu);
        System.out.println(lowCaloricDishesNameList);

        List<String> collect = menu.stream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 返回低热量的菜肴名称
     */
    public static List<String> getLowCaloricDishesNameList(List<Dish> dishList) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishList) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish lowCaloricDish : lowCaloricDishes) {
            lowCaloricDishesName.add(lowCaloricDish.getName());
        }
        return lowCaloricDishesName;
    }
}
