package com.hellodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.hellodev"})
public class ConsumerDeptFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDeptFeignApplication.class, args);
    }

}
