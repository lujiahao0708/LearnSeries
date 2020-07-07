package com.lujiahao.ordered;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 顺序消息发送
 * @author lujiahao
 * @date 2020-06-03
 */
public class OrderedProducer {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("ordered_Producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        //producer.setDefaultTopicQueueNums(1);

        // 第一组消息发送到 queueId=0 的队列中
        for (int i = 0; i < 5; i++) {
            Message msg = new Message("TopicOrderTest", "TAG_order_1", "KEY_order_1" + i, ("BODY_order_1_" + i).getBytes());
            SendResult sendResult = producer.send(msg, (mqs, msg1, arg) -> {
                Integer id = (Integer) arg;
                int index = id % mqs.size();
                return mqs.get(index);
            }, 0);
            System.out.println(sendResult);
        }

        // 第二组消息发送到 queueId=1 的队列中
        for (int i = 0; i < 5; i++) {
            Message msg = new Message("TopicOrderTest", "TAG_order_2", "KEY_order_2" + i, ("BODY_order_2_" + i).getBytes());
            SendResult sendResult = producer.send(msg, (mqs, msg1, arg) -> {
                Integer id = (Integer) arg;
                int index = id % mqs.size();
                return mqs.get(index);
            }, 1);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}