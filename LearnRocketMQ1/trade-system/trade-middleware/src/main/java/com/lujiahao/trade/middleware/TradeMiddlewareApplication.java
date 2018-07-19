package com.lujiahao.trade.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lujiahao.trade.middleware")
public class TradeMiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeMiddlewareApplication.class, args);
    }
}
