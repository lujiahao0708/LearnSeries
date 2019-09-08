package com.hellodev.search;

import com.hellodev.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author lujiahao
 * @date 2019-09-07 11:35
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }
}
