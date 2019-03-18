package com.lujiahao.learnjava8.chapter8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author lujiahao
 * @date 2019-03-18 17:25
 */
public class ProductFactoryLambda {
    private final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new IllegalArgumentException("No such product " + name);
    }

    public static void main(String[] args) {
        Product p = ProductFactoryLambda.createProduct("loan");
        System.out.println(p);
    }
}
