package com.hellodev.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.hellodev.common.utils.IdWorker;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class, args);
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }

}

