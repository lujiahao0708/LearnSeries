package com.lujiahao.java8inaction.chapter8.strategy;

/**
 * @author lujiahao
 * @date 2019-03-18 16:43
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}