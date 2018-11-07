package com.lujiahao.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "rocket.order")
@Data
public class CarFactOrderConfig extends BaseRocketMqProperty {
}
