package com.lujiahao.learnjava8.chapter3;

import java.util.function.Consumer;

/**
 * @author lujiahao
 * @date 2019-03-05 17:06
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Consumer<String> c = System.out::println;
        c.accept("sss");


    }
}
