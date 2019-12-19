package com.lujiahao.java8inaction.chapter8.strategy;

/**
 * @author lujiahao
 * @date 2019-03-18 16:42
 */
public interface ValidationStrategy{
    boolean execute(String s);
}
