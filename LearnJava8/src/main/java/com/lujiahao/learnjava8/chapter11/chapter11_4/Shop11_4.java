package com.lujiahao.learnjava8.chapter11.chapter11_4;

import com.lujiahao.learnjava8.Java8Util;

import java.util.Random;

/**
 * @author lujiahao
 * @date 2019-03-23 22:08
 */
public class Shop11_4 {
    private String name;

    public Shop11_4(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        Java8Util.delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
