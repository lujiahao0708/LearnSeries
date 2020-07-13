package com.lujiahao.concurrent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestSimpleDataFormate {
    public static void main(String[] args){
        while (true) {
            new Thread(() -> time() , "T1").start();
        }
//        for (int i = 0; i < 10000; i++) {
//            
//            new Thread(() -> time() , "T2").start();
//        }
    }
    
    public static void time() {
        List<Date> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Date());
        }
        // 模拟数据库获取数据
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (Date date : list) {
            String bookingDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            //System.out.println(Thread.currentThread().getName() + " " + bookingDate);
        }
    }
}
