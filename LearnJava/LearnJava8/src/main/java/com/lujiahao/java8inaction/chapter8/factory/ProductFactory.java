package com.lujiahao.java8inaction.chapter8.factory;

/**
 * @author lujiahao
 * @date 2019-03-18 17:25
 */
public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("loan");
        System.out.println(p);
    }
}
