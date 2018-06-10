package com.lujiahao.trade.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan(basePackages = "com.lujiahao.trade.dao.mapper")
@ComponentScan(basePackages = "com.lujiahao.trade.user")
public class TradeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeUserApplication.class, args);
    }
}
