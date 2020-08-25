package com.lujiahao.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SendMsgService {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer_9876 = new DefaultMQProducer("TestGroup_9876");
        producer_9876.setNamesrvAddr("192.168.12.8:9876");
        producer_9876.setInstanceName("instanceName_9876");
        producer_9876.start();
        System.out.println("Producer_9876属性信息:" + producer_9876);

        Message message_9876 = new Message(
                "TestTopic1", "TagA",
                "9876 " + LocalDateTime.now(),
                "Hello RocketMQ!".getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult_9876 = producer_9876.send(message_9876);
        System.out.println("Producer_9876发送结果:" + sendResult_9876);


        DefaultMQProducer producer_9877 = new DefaultMQProducer("TestGroup_9877");
        producer_9877.setNamesrvAddr("192.168.12.8:9877");
        producer_9877.setInstanceName("instanceName_9877");
        producer_9877.start();
        System.out.println("Producer_9877属性信息:" + producer_9877);

        Message message_9877 = new Message(
                "TestTopic2", "TagA",
                "9877 " + LocalDateTime.now(),
                "Hello RocketMQ!".getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult_9877 = producer_9877.send(message_9877);
        System.out.println("Producer_9877发送结果:" + sendResult_9877);

        // producer 最后再关闭
        producer_9876.shutdown();
        producer_9877.shutdown();
    }

}
