package com.hellodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进 eureka 服务中
public class ProviderDept8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDept8002Application.class, args);
    }

}
