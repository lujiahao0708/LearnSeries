package com.lujiahao.ordered;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OrderedConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name_3");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TopicOrderTest", "*");
        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            context.setAutoCommit(true);
            for (MessageExt msg : msgs) {
                // 可以看到每个queue有唯一的consume线程来消费, 并且每个 queue 中的消息消费是顺序的
                System.out.println("consumeThread=" + Thread.currentThread().getName() +
                        " queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
            }

            try {
                //模拟业务逻辑处理中...
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("Consumer Started.");
    }
}
