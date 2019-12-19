package com.lujiahao.java8inaction.chapter8.strategy.lambda;

import com.lujiahao.java8inaction.chapter8.factory.Bond;
import com.lujiahao.java8inaction.chapter8.factory.Loan;
import com.lujiahao.java8inaction.chapter8.factory.Product;
import com.lujiahao.java8inaction.chapter8.factory.Stock;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author lujiahao
 * @date 2019-03-18 16:43
 */
//@Data
@Accessors(chain = true)
@Builder
public class Context {
    private Function<String, String> strategy;

    public Context(Function<String, String> strategy) {
        this.strategy = strategy;
    }

    public String validate(String orderNo, Integer serviceTypeId) {
        if (1 == serviceTypeId) {
            strategy = (t) -> t + "a";
            return strategy.apply(orderNo);
        } else if (2 == serviceTypeId) {
            strategy = (t) -> t + "b";
            return strategy.apply(orderNo);
        }
        throw new IllegalArgumentException("No such product " );
    }
}