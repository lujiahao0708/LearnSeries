package com.lujiahao.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 发送批量消息
 * @author lujiahao
 * @date 2020-05-29
 */
public class BatchProducer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer("sync_msg_group");
        // 设置 nameserver地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动 producer 实例
        producer.start();

        List<Message> messageList = IntStream.range(0, 10).mapToObj(r -> {
            // 创建消息,并制定 topic/tag和消息体
            Message message = null;
            try {
                message = new Message(
                        "TopicTest",
                        "TagA",
                        ("Hello RocketMQ " + r).getBytes(RemotingHelper.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return message;
        }).collect(Collectors.toList());

        // 发送消息到broker
        SendResult sendResult = producer.send(messageList);
        // 输出发送结果
        System.out.printf("%s%n", sendResult);

        // 关闭 producer 实例
        producer.shutdown();
    }
}
