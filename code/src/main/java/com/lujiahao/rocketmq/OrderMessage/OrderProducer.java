package com.lujiahao.rocketmq.OrderMessage;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-05-26 下午6:12
 */
public class OrderProducer {
    public static void main(String[] args) {
        try {
            // 生产者的组名
            DefaultMQProducer producer = new DefaultMQProducer("order_Producer");
            producer.setNamesrvAddr("127.0.0.1:9876");
            producer.start();

            for (int i = 0; i < 50; i++) {
                Message msg = new Message("TopicOrderTest", "TAG_order_1", "KEY_order_1" + i, ("BODY_order_1 " + i).getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 0);
                System.out.println(sendResult);
            }
            // arg就是queue的下标,一个topic会分配4个queue

            for (int i = 0; i < 50; i++) {
                Message msg = new Message("TopicOrderTest", "TAG_order_2", "KEY_order_2" + i, ("BODY_order_2 " + i).getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 1);
                System.out.println(sendResult);
            }

//            for (int i = 0; i < 5; i++) {
//                Message msg = new Message("TopicOrderTest", "TAG_order_3", "KEY_order_3" + i, ("BODY_order_3 " + i).getBytes());
//
//                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
//                    @Override
//                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
//                        Integer id = (Integer) arg;
//                        int index = id % mqs.size();
//                        return mqs.get(index);
//                    }
//                }, 2);
//                System.out.println(sendResult);
//            }

            producer.shutdown();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
}
