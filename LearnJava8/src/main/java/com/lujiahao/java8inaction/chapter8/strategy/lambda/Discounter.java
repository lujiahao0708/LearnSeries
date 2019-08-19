package com.lujiahao.java8inaction.chapter8.strategy.lambda;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

/**
 * @author lujiahao
 * @date 2019-08-19 16:14
 */
public interface Discounter extends UnaryOperator<BigDecimal> {

    default Discounter combine(Discounter after) {
        return value -> after.apply(this.apply(value));
    }

    static Discounter factory(Integer type) {
        if (1 == type) {
            return christmas();
        } else if (2 == type) {
            return newYear();
        } else {
            return easter();
        }
    }

    static Discounter christmas() {
        return (amount) -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYear() {
        return (amount) -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    static Discounter easter() {
        return (amount) -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
