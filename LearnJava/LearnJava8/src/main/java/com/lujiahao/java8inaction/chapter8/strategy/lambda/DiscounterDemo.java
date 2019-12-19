package com.lujiahao.java8inaction.chapter8.strategy.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.lujiahao.java8inaction.chapter8.strategy.lambda.Discounter.*;

/**
 * @author lujiahao
 * @date 2019-08-19 16:15
 */
public class DiscounterDemo {
    public static void main(String[] args) {
//        List<Discounter> discounters = Arrays.asList(christmas(), newYear(), easter());
//
//        BigDecimal amount = BigDecimal.valueOf(100);
//
//        final Discounter combinedDiscounter = discounters
//                .stream()
//                .reduce(v -> v, Discounter::combine);
//
//        BigDecimal apply = combinedDiscounter.apply(amount);
//        System.out.println(apply.toString());


        final Function<BigDecimal, BigDecimal> combinedDiscounters = Discounter.factory(1);
        BigDecimal apply1 = combinedDiscounters.apply(BigDecimal.valueOf(100));
        System.out.println(apply1);
    }
}
