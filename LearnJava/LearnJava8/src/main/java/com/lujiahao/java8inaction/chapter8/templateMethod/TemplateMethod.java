package com.lujiahao.java8inaction.chapter8.templateMethod;

/**
 * @author lujiahao
 * @date 2019-03-18 16:55
 */
public class TemplateMethod {
    public static void main(String[] args) {
        new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println(c.getName() + " happy!");
            }
        }.processCustomer(1);

        new OnlineBankingLambda().processCustomer(1, (Customer c) -> System.out.println(c.getName() + " happy!"));
    }
}
