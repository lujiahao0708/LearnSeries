package com.lujiahao.learnjava8;

import java.util.Optional;

/**
 * @author lujiahao
 * @date 2018-11-08 11:41
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.toString());
    }
}
