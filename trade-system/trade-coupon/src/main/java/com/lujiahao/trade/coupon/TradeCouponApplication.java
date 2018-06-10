package com.lujiahao.trade.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lujiahao.trade.coupon")
public class TradeCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeCouponApplication.class, args);
    }
}
