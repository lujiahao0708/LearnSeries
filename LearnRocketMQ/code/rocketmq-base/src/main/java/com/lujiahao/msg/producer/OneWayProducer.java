package com.lujiahao.msg.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

/**
 * 单向模式发送消息
 * @author lujiahao
 * @date 2020-06-02
 */
public class OneWayProducer {

    public static void main(String[] args) throws Exception{
        // 实例化消息生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer("one_way_msg_group");
        // 设置 NameServer 地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动 Producer
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建消息体
            Message message = new Message(
                    "TopicTest",
                    "TagA",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送单向消息,没有任何返回结果
            producer.sendOneway(message);
        }
        // 关闭 Producer
        producer.shutdown();
    }
}
