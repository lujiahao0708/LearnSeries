package com.lujiahao.msg.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 发送同步消息
 *
 * @author lujiahao
 * @date 2020-05-29
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer("sync_msg_group");
        // 设置 nameserver地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动 producer 实例
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建消息,并制定 topic/tag和消息体
            Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到一个 broker
            SendResult sendResult = producer.send(message);
            // 输出发送结果
            System.out.printf("%s%n", sendResult);
        }
        // 关闭 producer 实例
        producer.shutdown();
    }
}
