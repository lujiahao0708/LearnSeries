package com.lujiahao;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.time.LocalDateTime;

public class ProducerNoInstanceName {

    private static String groupName = "TestGroup";
    private static String topic = "TestTopic";
    private static String tag = "TagA";
    private static String nameSrvAddr_9876 = "127.0.0.1:9876";
    private static String instanceName_9876 = "instanceName_9876";
    private static String key_msg_9876 = nameSrvAddr_9876 + " " + LocalDateTime.now();

    private static String nameSrvAddr_9877 = "111.231.199.76:9876";
    private static String instanceName_9877 = "instanceName_9877";
    private static String key_msg_9877 = nameSrvAddr_9877 + " " + LocalDateTime.now();

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer_9876 = new DefaultMQProducer(groupName);
        producer_9876.setNamesrvAddr(nameSrvAddr_9876);
        producer_9876.setInstanceName(instanceName_9876);
        producer_9876.start();
        System.out.println("Producer_9876属性信息:" + producer_9876);

        Message message_9876 = new Message(topic, tag, key_msg_9876, key_msg_9876.getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult_9876 = producer_9876.send(message_9876);
        System.out.println("Producer_9876发送结果:" + sendResult_9876);
        producer_9876.shutdown();


        DefaultMQProducer producer_9877 = new DefaultMQProducer(groupName);
        producer_9877.setNamesrvAddr(nameSrvAddr_9877);
        producer_9877.setInstanceName(instanceName_9877);
        producer_9877.start();
        System.out.println("Producer_9877属性信息:" + producer_9877);

        Message message_9877 = new Message(topic, tag, key_msg_9877, key_msg_9877.getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult sendResult_9877 = producer_9877.send(message_9877);
        System.out.println("Producer_9877发送结果:" + sendResult_9877);
        producer_9877.shutdown();
    }
}
