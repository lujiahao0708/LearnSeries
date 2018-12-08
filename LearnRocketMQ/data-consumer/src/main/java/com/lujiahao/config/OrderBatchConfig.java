package com.lujiahao.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rocket.order-batch")
@Data
public class OrderBatchConfig extends BaseRocketMqProperty {
}
