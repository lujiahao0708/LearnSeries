package com.lujiahao.msg.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;


/**
 * 负载均衡模式消费消息
 * @author lujiahao
 * @date 2020-06-02
 */
public class ClusteringConsumer {
    public static void main(String[] args) throws Exception{
        // 实例化消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("clustering_consumer_group");
        // 设置 nameserver
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅 Topic
        consumer.subscribe("TopicTest", "TagA");
        // 设置负载均衡消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // 注册回调函数,处理消息
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 启动消费者
        consumer.start();
    }
}
