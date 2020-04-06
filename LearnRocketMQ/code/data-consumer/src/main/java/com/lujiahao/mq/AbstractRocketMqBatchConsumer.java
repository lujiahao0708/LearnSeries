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

import java.util.List;
import java.util.UUID;

/**
 * rocketmq 消费者 批量消费
 * @author lujiahao
 * @date 2018-12-06
 */
public abstract class AbstractRocketMqBatchConsumer extends AbstractLifeCycle {

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
            consumer.setNamesrvAddr(mqProperty.getNamesrvAddr());
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            String instanceName = StringUtils.isBlank(mqProperty.getInstanceName()) ? String.valueOf(System.currentTimeMillis()) : mqProperty.getInstanceName();
            consumer.setInstanceName(instanceName);
            int batchMaxSize = mqProperty.getBatchMaxSize() <= 0 ? 16 : mqProperty.getBatchMaxSize();
            consumer.setConsumeMessageBatchMaxSize(batchMaxSize);
            consumer.subscribe(mqProperty.getTopic(), mqProperty.getTag());
            // 注册监听
            consumer.registerMessageListener((MessageListenerOrderly) (msg, context) -> {
                MDC.put(TraceConstant.TRACE_KEY, UUID.randomUUID().toString().replace("-", ""));
                try {
                    if (msg == null || msg.size() <= 0) {
                        logger.warn("[BatchConsumer]消息集合为null或size小于等于0 mqProperty:{}", mqProperty);
                        return ConsumeOrderlyStatus.SUCCESS;
                    }
                    boolean isSuccess = handleBatchMessage(msg);
                    if (!isSuccess) {
                        logger.warn("[BatchConsumer]处理消息失败 mqProperty:{} msgSize:{}", mqProperty, msg.size());
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    }
                } catch (Exception e) {
                    logger.error("[BatchConsumer]mqProperty:{} msgSize:{}", mqProperty, msg.size(), e);
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                } finally {
                    MDC.remove(TraceConstant.TRACE_KEY);
                }
                return ConsumeOrderlyStatus.SUCCESS;
            });
            consumer.start();
            logger.info("[BatchConsumer][consumer配置:{}]", mqProperty);
            isStart = true;
        } catch (MQClientException e) {
            logger.error("[BatchConsumer][mqProperty:{}]", mqProperty, e);
        }
    }

    /**
     * 处理消息
     */
    public abstract boolean handleBatchMessage(List<MessageExt> batchMsg);

    /**
     * 获取配信息
     */
    public abstract BaseRocketMqProperty getMqProperty();
}
