package com.lujiahao.cfgbeans;

/**
 * @author lujiahao
 * @date 2019-07-21 13:13
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced // 负载均衡注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}