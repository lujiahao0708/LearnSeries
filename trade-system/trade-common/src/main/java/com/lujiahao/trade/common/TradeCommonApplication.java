package com.lujiahao.trade.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lujiahao.trade.common.rocketmq")
public class TradeCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeCommonApplication.class, args);
    }
}
