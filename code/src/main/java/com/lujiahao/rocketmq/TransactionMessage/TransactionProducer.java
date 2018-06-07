package com.lujiahao.rocketmq.TransactionMessage;

import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * @author lujiahao
 * @date 2018-05-30 下午7:44
 */
public class TransactionProducer {
    public static void main(String[] args) {
        try {
            TransactionMQProducer producer = new TransactionMQProducer("TransactionProducer");
            producer.setNamesrvAddr("127.0.0.1:9876");
            producer.setTransactionCheckListener(new TransactionCheckListener() {
                @Override
                public LocalTransactionState checkLocalTransactionState(MessageExt messageExt) {
                    // 但是，注意到本地事务执行失败的消息，RMQ并没有check listener？这是为什么呢？
                    // 因为RMQ在3.0.8的时候还是支持check listener回查机制的，但是到了3.2.6的时候将事务回查机制“阉割”了！
                    System.out.println("server check TrMsg:" + messageExt.toString());
                    return LocalTransactionState.COMMIT_MESSAGE;
                }
            });
            producer.start();

            TransactionExecuterImpl transactionExecuter = new TransactionExecuterImpl();
            Message msg = new Message("TopicTransactionTest", "TAG_Transaction_1", "KEY_Transaction_1", "BODY_Transaction_1 ".getBytes());
            TransactionSendResult sendResult = producer.sendMessageInTransaction(msg, transactionExecuter, "lujiahao");
            System.out.println("sendResult:" + sendResult.toString());

            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
