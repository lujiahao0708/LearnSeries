package com.lujiahao.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MQ生产者配置
 * @author lujiahao
 * @date 2018/11/3
 */
@Configuration
public class MqProducerConfig {

    @Bean
    public RocketMqProducer dataProducer(@Value("${rocketUrl}") String namesrvAddr) {
        String groupName = "dataGroup";
        String instanceName = "dataMq";
        return new RocketMqProducer(groupName, namesrvAddr, instanceName);
    }
}
