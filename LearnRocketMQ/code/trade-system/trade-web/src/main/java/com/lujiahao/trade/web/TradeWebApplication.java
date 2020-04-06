package com.lujiahao.trade.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lujiahao.trade.web")
public class TradeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeWebApplication.class, args);
    }
}
