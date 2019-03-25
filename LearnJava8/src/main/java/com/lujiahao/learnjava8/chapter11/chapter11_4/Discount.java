package com.lujiahao.learnjava8.chapter11.chapter11_4;

import com.lujiahao.learnjava8.Java8Util;

/**
 * 折扣代码
 * @author lujiahao
 * @date 2019-03-23 22:06
 */
public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                // 将折扣代码应用于商品最初的原始价格
                Discount.apply(quote.getPrice(),
                        quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        // 模拟discount服务响应的延迟
        Java8Util.delay();
        //return format(price * (100 - code.percentage) / 100);
        return (price * (100 - code.percentage) / 100);
    }
}
