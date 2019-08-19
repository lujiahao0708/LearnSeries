package com.lujiahao.java8inaction.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @author lujiahao
 * @date 2019-03-25 20:29
 */
public class LocalDateAndLocalTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfYear = date.getDayOfYear();
        int lengthOfMonth = date.lengthOfMonth();
        boolean leapYear = date.isLeapYear();

        System.out.println(LocalDate.now());

        System.out.println("LocalDate演示:");
        System.out.println("年份:" + year);
        System.out.println("月份:" + month + "   月份:" + month.getDisplayName(TextStyle.FULL, Locale.CHINA));
        System.out.println("号:" + dayOfMonth);
        System.out.println("星期:" + dayOfWeek);
        System.out.println("一年中第几天:" + dayOfYear);
        System.out.println("当前月份共几天:" + lengthOfMonth);
        System.out.println("是否是闰年:" + leapYear);
        System.out.println("当前日期:" + LocalDate.now());


        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth1 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year1);
        System.out.println(month1);
        System.out.println(dayOfMonth1);

        System.out.println("-----------------------");

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("hour:" + hour);
        System.out.println("minute:" + minute);
        System.out.println("second:" + second);

        System.out.println("-----------------------");
        // 会跑异常
        // LocalDate localDate = LocalDate.parse("2014-3-18");
        LocalDate localDate = LocalDate.parse("2014-03-18");
        LocalTime localTime = LocalTime.parse("13:45:20");
        System.out.println(localDate);
        System.out.println(localTime);
    }
}
