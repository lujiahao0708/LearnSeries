package com.lujiahao.trade.middleware.rocketmq.base;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lujiahao.trade.middleware.rocketmq.IConsumer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-06-06 下午1:13
 */
public abstract class AbstractRocketMqConsumer implements IConsumer {
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractRocketMqConsumer.class);

    private ConsumerProperties mqProperty;

    protected DefaultMQPushConsumer consumer = null;

    @Override
    public void start() {
        this.mqProperty = getMqProperty();
        listen();
    }

    @Override
    public void stop() {
        if (consumer != null) {
            consumer.shutdown();
        }
    }

    public void listen() {
        try {
            // todo 校验
            if (StringUtils.isBlank(mqProperty.getGroupName())) {
                return;
            }
            consumer = new DefaultMQPushConsumer(mqProperty.getGroupName());
            // MQ地址
            consumer.setNamesrvAddr(mqProperty.getNamesrvAddr());
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            consumer.setConsumeMessageBatchMaxSize(mqProperty.getBatchMaxSize());
            consumer.subscribe(mqProperty.getTopic(), mqProperty.getTag());
            consumer.setInstanceName(mqProperty.getInstanceName());
            // 注册监听
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                    for (int i = 0; i < msgs.size(); i++) {
                        MessageExt msgExt = msgs.get(i);
                        String msgId = msgExt.getMsgId();
                        String msgBody = new String(msgExt.getBody());
                        LOGGER.debug("msgs-size={}, msgId={}, msgBody={}", msgs.size(), msgId, msgBody);
                        try {
                            handleMessage(msgBody, msgId);
                        } catch (Exception e) {
                            LOGGER.error("consumer error: topic={}, groupName={}, data:{}", mqProperty.getTopic(), mqProperty.getGroupName(), msgBody, e);
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            LOGGER.info("mqProperty:{}", mqProperty);
        } catch (MQClientException e) {
            LOGGER.error("topic={}, groupName={} started error", mqProperty.getTopic(), mqProperty.getGroupName(), e);
        }
    }

    /**
     * 处理消息
     * @param message
     * @param msgId
     * @throws Exception
     */
    public abstract void handleMessage(String message, String msgId) throws Exception;

    /**
     * 获取配置信息
     * @return
     */
    public abstract ConsumerProperties getMqProperty();
}