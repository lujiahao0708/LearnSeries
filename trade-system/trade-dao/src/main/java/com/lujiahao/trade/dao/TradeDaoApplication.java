package com.lujiahao.trade.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.lujiahao.trade.dao.mapper")
public class TradeDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeDaoApplication.class, args);
    }
}
