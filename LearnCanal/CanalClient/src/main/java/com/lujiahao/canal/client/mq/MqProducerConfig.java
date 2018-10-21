//package com.lujiahao.canal.client.mq;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * RocketMQ生产者配置
// * @author lujiahao
// * @date 2018/10/21
// */
//@Configuration
//public class MqProducerConfig {
//
//    /**
//     *
//     * @param namesrvAddr
//     * @return
//     */
//    @Bean
//    public RocketMqProducer testCanalProducer(@Value("${rocketUrl}") String namesrvAddr) {
//        String groupName = "businessGroup";
//        String instanceName = "businessMq";
//        return new RocketMqProducer(groupName, namesrvAddr, instanceName);
//    }
//}
