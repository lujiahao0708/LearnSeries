package com.lujiahao.trade.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lujiahao.trade.pay")
public class TradePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradePayApplication.class, args);
    }
}
