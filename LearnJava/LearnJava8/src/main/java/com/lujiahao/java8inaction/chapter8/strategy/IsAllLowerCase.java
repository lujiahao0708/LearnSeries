package com.lujiahao.java8inaction.chapter8.strategy;

/**
 * @author lujiahao
 * @date 2019-03-18 16:42
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
