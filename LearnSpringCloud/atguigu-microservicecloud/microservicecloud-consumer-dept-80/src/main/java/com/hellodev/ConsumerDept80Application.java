package com.hellodev;

import com.selfrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration= MySelfRule.class)
public class ConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80Application.class, args);
    }

}
