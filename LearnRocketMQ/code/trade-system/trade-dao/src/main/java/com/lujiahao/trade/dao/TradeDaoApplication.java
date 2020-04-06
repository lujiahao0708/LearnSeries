package com.lujiahao.trade.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lujiahao.trade.dao.mapper")
@ComponentScan(basePackages = "com.lujiahao.trade.dao")
public class TradeDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeDaoApplication.class, args);
    }
}
