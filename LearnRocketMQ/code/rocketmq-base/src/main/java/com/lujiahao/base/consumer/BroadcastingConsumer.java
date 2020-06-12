package com.lujiahao.base.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * 广播模式消费消息
 *
 * @author lujiahao
 * @date 2020-06-02
 */
public class BroadcastingConsumer {
    public static void main(String[] args) throws Exception {
        // 设置生产者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcasting_consumer_group");
        // 设置nameserver
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅 topic
        consumer.subscribe("TopicTest", "TagA");
        // 设置广播模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 注册回调函数,处理消息
        consumer.registerMessageListener(
                (MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
                    System.out.printf("%s Receive New Messages: %s %n",
                            Thread.currentThread().getName(), list);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                });
        consumer.start();
    }
}
