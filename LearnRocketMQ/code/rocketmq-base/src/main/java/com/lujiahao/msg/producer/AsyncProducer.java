package com.lujiahao.msg.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

/**
 * 异步模式发送消息
 * @author lujiahao
 * @date 2020-06-02
 */
public class AsyncProducer {

    public static void main(String[] args) throws Exception{
        // 实例化消息生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer("async_msg_group");
        // 设置 NameServer 地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动 Producer
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            // 创建消息体
            Message message = new Message(
                    "TopicTest",
                    "TagA",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 接收异步返回结果回调
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("发送结果:%s\n", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.printf("发送异常:%s\n", throwable);
                }
            });
            // 这里暂停一秒的目的是为了防止这个异常出现
            // org.apache.rocketmq.client.exception.MQClientException:
            // The producer service state not OK, SHUTDOWN_ALREADY
            TimeUnit.SECONDS.sleep(1);
        }
        // 关闭 Producer
        producer.shutdown();
    }
}
