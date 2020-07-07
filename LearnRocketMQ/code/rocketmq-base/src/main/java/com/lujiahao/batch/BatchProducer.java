package com.lujiahao.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BatchProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("batch_msg_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        List<Message> messageList = IntStream.range(0, 10).mapToObj(r -> {
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

        SendResult sendResult = producer.send(messageList);
        System.out.printf("%s%n", sendResult);

        producer.shutdown();
    }
}
