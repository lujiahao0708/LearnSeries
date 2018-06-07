package com.lujiahao.rocketmq.NormalMessage;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * @author lujiahao
 * @date 2018-05-28 下午8:47
 */
public class NormalProducer {
    public static void main(String[] args) {
        try {
            // 生产者的组名
            DefaultMQProducer producer = new DefaultMQProducer("Normal_Producer");
            producer.setNamesrvAddr("127.0.0.1:9876");
            producer.start();

            Message msg = new Message("TopicNormalTest", "TAG_Normal_1", "KEY_Normal_1", "BODY_Normal_1 ".getBytes());

            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);

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
