package com.lujiahao.java8inaction.chapter11.chapter11_4;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2019-03-23 22:10
 */
@Data
public class Quote {
    private final String shopName;
    private final double price;
    private Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }
}
