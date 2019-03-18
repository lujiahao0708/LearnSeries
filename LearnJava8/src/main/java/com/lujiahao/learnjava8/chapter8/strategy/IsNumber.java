package com.lujiahao.learnjava8.chapter8.strategy;

/**
 * @author lujiahao
 * @date 2019-03-18 16:43
 */
public class IsNumber implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}