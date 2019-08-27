package com.hellodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 本服务启动后会自动注册进 eureka 服务中
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
// 对hystrix熔断机制的支持
@EnableCircuitBreaker
public class ProviderDeptHystrix8001Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderDeptHystrix8001Application.class, args);
	}

}
