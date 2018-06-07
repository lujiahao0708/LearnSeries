package com.lujiahao.rocketmq.TransactionMessage;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;

import java.util.Random;

/**
 * @author lujiahao
 * @date 2018-05-30 下午8:02
 */
public class TransactionExecuterImpl implements LocalTransactionExecuter {
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message message, Object o) {
        System.out.println("--->参数:" + o);
        try {
            if (new Random().nextInt(3) == 2) {
                int a = 1 / 0;
            }

            System.out.println("本地事务执行成功,发送确认消息");
        } catch (Exception e) {
            System.out.println("本地事务执行失败");
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
