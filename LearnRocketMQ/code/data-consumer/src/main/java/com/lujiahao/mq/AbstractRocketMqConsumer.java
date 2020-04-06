package com.lujiahao.mq;

import com.lujiahao.config.BaseRocketMqProperty;
import com.lujiahao.constant.TraceConstant;
import com.lujiahao.lifecycle.AbstractLifeCycle;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * rocketmq 消费者
 * @author lujiahao
 * @date 2018/11/1
 */
public abstract class AbstractRocketMqConsumer extends AbstractLifeCycle {

    /**
     * mq相关配置
     */
    private BaseRocketMqProperty mqProperty;

    protected DefaultMQPushConsumer consumer = null;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static volatile boolean isStart = false;

    @Override
    public void start() {
        this.mqProperty = getMqProperty();
        listen();
    }

    @Override
    public boolean isStart() {
        return isStart;
    }

    @Override
    public void shutdown() {
        if (consumer != null) {
            consumer.shutdown();
        }
    }

    public void listen() {
        try {
            consumer = new DefaultMQPushConsumer(mqProperty.getGroupName());
            // MQ地址
            consumer.setNamesrvAddr(mqProperty.getNamesrvAddr());
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            String instanceName = mqProperty.getInstanceName();
            if (StringUtils.isBlank(instanceName)) {
                instanceName = String.valueOf(System.currentTimeMillis());
            }
            consumer.setInstanceName(instanceName);
            int batchSize = mqProperty.getBatchMaxSize();
            if (batchSize <= 0) {
                batchSize = 16;
            }
            consumer.setConsumeMessageBatchMaxSize(batchSize);
            consumer.subscribe(mqProperty.getTopic(), mqProperty.getTag());
            // 注册监听
            consumer.registerMessageListener((MessageListenerOrderly) (msg, context) -> {
                for (int i = 0; i < msg.size(); i++) {
                    MessageExt msgExt = msg.get(i);
                    String msgId = msgExt.getMsgId();
                    MDC.put(TraceConstant.TRACE_KEY, UUID.randomUUID().toString().replace("-", ""));
                    String msgBody = new String(msgExt.getBody());
                    logger.debug("msgSize={}, msgId={}, msgBody={}", msg.size(), msgId, msgBody);
                    try {
                        boolean isSuccess = handleMessage(msgBody, msgId);
                        if (!isSuccess) {
                            logger.warn("处理消息失败 mqProperty:{} msgExt:{}", mqProperty, msgExt);
                            return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                        }
                    } catch (Exception e) {
                        logger.error("mqProperty:{} msgExt:{}", mqProperty, msgExt, e);
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    } finally {
                        MDC.remove(TraceConstant.TRACE_KEY);
                    }
                }
                return ConsumeOrderlyStatus.SUCCESS;
            });
            consumer.start();
            logger.info("consumer配置:{}", mqProperty);
            isStart = true;
        } catch (MQClientException e) {
            logger.error("mqProperty:{}", mqProperty, e);
        }
    }

    /**
     * 处理消息
     *
     * @param message
     * @param msgId
     * @return
     */
    public abstract boolean handleMessage(String message, String msgId);

    /**
     * 获取配信息
     *
     * @return
     */
    public abstract BaseRocketMqProperty getMqProperty();
}
