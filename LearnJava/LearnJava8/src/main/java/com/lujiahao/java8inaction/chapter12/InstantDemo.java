package com.lujiahao.java8inaction.chapter12;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lujiahao
 * @date 2019-03-27 11:26
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(2013, 10, 11);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
    }
}
