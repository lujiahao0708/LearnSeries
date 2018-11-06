package com.lujiahao.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lujiahao
 * @date 2018/11/3
 */
@Configuration
@ConfigurationProperties(prefix = "rocket.order")
@Data
public class OrderConfig extends BaseRocketMqProperty {
}
