package com.lujiahao.canal.client.mq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * rocketmq生产者
 * @author lujiahao
 * @date 2018/10/21
 */
public class RocketMqProducer {

    protected static final Logger logger = LoggerFactory.getLogger(RocketMqProducer.class);
    private final static int RETRY_TIMES_WHEN_SEND_FAILED = 3;
    private final static int SEND_MSG_TIMEOUT = 3000;

    protected String groupName;
    protected DefaultMQProducer producer;
    protected String namesrvAddr;

    public RocketMqProducer(String groupName, String namesrvAddr, String instanceName) {
        this.groupName = groupName;
        this.namesrvAddr = namesrvAddr;
        try {
            producer = new DefaultMQProducer(groupName);
            producer.setNamesrvAddr(namesrvAddr);
            producer.setInstanceName(instanceName);
            producer.setRetryTimesWhenSendFailed(RETRY_TIMES_WHEN_SEND_FAILED);
            producer.setSendMsgTimeout(SEND_MSG_TIMEOUT);
            producer.start();
        } catch (Exception e) {
            logger.error("rocketMq config error!", e);
        }
    }

    public boolean sendMessage(String topic, String tag, String key, String value) {
        SendResult sendResult = null;
        try {
            Message msg = new Message(topic, tag, key, value.getBytes());
            sendResult = producer.send(msg, (mqs, message, arg)->{
                    int index = mqs.size() - 1 & RocketMqProducer.hash(arg);
                    return mqs.get(index);
                }, key);
            if (sendResult == null || sendResult.getSendStatus() != SendStatus.SEND_OK) {
                logger.warn("发送mq失败: topic:{} tags:{} groupName:{} namesrvAddr:{} " +
                                    "value:{} sendStatus:{}", topic, tag, groupName, namesrvAddr, value, sendResult);
                return false;
            } else {
                logger.info("发送mq成功: topic:{} tags:{} groupName:{} namesrvAddr:{} " +
                                    "value:{} sendStatus:{}", topic, tag, groupName, namesrvAddr, value, sendResult);
                return true;
            }
        } catch (Throwable e) {
            logger.error("发送mq异常: topic:{} tags:{} groupName:{} namesrvAddr:{} value:{} sendStatus:{}",
                    topic, tag, groupName, namesrvAddr, value, sendResult, e);
            return false;
        }
    }

    private static int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
}
