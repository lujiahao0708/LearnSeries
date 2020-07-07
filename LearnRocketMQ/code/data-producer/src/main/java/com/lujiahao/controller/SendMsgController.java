package com.lujiahao.controller;

import com.lujiahao.service.SendMsgService;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class SendMsgController {

    @Autowired
    private SendMsgService sendMsgService;
    private static String group = "TestGroup";
    private static String topic = "TestTopic";
    private static String tag = "TagA";
    private static String nameSrvAddr_9876 = "127.0.0.1:9876";
    private static String nameSrvAddr_9877 = "127.0.0.1:9877";

    @GetMapping("/send")
    public void send() {

    }

    public static void sendMsg(String groupName, String nameSrvAddr, String topic, String tag, String key, String msg) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer(groupName);
            producer.setNamesrvAddr(nameSrvAddr);
            producer.start();

            System.out.println(producer);

            Message message = new Message(topic, tag, key, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);

            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        sendMsg(group, nameSrvAddr_9876, topic, tag, "msg_to_nameSrvAddr_9876", "msg_to_nameSrvAddr_9876");
        sendMsg(group, nameSrvAddr_9877, topic, tag, "msg_to_nameSrvAddr_9877", "msg_to_nameSrvAddr_9877");
    }

//    @GetMapping("/send2")
//    public void send2() {
//        try {
//            try {
//                DefaultMQProducer producer = new DefaultMQProducer(group);
//                producer.setNamesrvAddr(nameSrvAddr);
//                producer.start();
//                System.out.println(producer);
//
//                Message message = new Message(topic, tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
//                SendResult sendResult = producer.send(message);
//                System.out.printf("%s%n", sendResult);
//
//                producer.shutdown();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
