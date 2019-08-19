package com.lujiahao.java8inaction.chapter8.strategy.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author lujiahao
 * @date 2019-08-19 15:05
 */
public class LambdaStrategyDemo {
    public static void main(String[] args) {
//        Context strategy1 = new Context((t, u) -> {
//            if (1 == u) {
//                return null;
//            }
//            return t + u;
//        });
//
//        Context strategy2 = new Context((t, u) -> {
//            if (2 == u) {
//                return null;
//            }
//            return t + u;
//        });


        String ss = Context.builder().build().validate("P123", 1);
        System.out.println(ss);

        String s = Context.builder().build().validate("P321", 2);
        System.out.println(s);
    }
}
