package com.hellodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdEurekaApplication.class, args);
	}

}
