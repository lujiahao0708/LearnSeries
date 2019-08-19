package com.lujiahao.java8inaction;

import com.lujiahao.java8inaction.chapter11.Shop;
import com.lujiahao.java8inaction.chapter11.chapter11_4.Shop11_4;
import com.lujiahao.java8inaction.chapter2.Apple;
import com.lujiahao.java8inaction.chapter4.Dish;
import com.lujiahao.java8inaction.chapter5.Trader;
import com.lujiahao.java8inaction.chapter5.Transaction;
import com.lujiahao.java8inaction.chapter8.templateMethod.Customer;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Dish> genMenu() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }

    public static List<Transaction> getTrans() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }

    public static Customer getCustomerWithId(int id) {
        return new Customer(id, "name" + id);
    }

    public static List<Shop> getShops() {
        return Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("MyFavoriteShop"),
                new Shop("MyFavoriteShop"),
                new Shop("MyFavoriteShop"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll")
        );
    }

    public static List<Shop11_4> getShop11_4() {
        return Arrays.asList(
                new Shop11_4("BestPrice"),
                new Shop11_4("LetsSaveBig"),
                new Shop11_4("LetsSaveBig"),
                new Shop11_4("MyFavoriteShop"),
                new Shop11_4("BuyItAll")
        );
    }
}
