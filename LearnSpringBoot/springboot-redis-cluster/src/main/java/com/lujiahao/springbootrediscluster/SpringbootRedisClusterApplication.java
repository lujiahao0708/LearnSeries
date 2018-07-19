package com.lujiahao.springbootrediscluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootRedisClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisClusterApplication.class, args);
	}
}
