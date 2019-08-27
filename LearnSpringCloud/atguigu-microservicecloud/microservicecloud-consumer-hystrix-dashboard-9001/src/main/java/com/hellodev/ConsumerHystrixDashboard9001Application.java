package com.hellodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixDashboard9001Application.class, args);
	}

}
