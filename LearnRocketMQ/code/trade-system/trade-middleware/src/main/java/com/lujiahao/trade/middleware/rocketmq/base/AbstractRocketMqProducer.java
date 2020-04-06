package com.lujiahao.trade.middleware.rocketmq.base;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.lujiahao.trade.common.exception.RocketMqException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * @author lujiahao
 * @date 2018-06-05 下午1:49
 */
public abstract class AbstractRocketMqProducer {
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractRocketMqProducer.class);

    private ProducerProperties mqProperty;

    protected DefaultMQProducer producer = null;

    @PostConstruct
    public void start() {
        this.mqProperty = getMqProperty();
        init();
    }

    public void init() {
        try {
            // todo 一些基本参数的校验
            if (StringUtils.isBlank(mqProperty.getGroupName())) {
                return;
            }
            producer = new DefaultMQProducer(mqProperty.getGroupName());
            producer.setNamesrvAddr(mqProperty.getNamesrvAddr());
            producer.setMaxMessageSize(mqProperty.getMaxMessageSize());
            producer.setSendMsgTimeout(mqProperty.getSendMsgTimeout());
            producer.start();
            LOGGER.info("mqProperty:{}", mqProperty);
        } catch (MQClientException e) {
            LOGGER.error("topic={}, groupName={} started error", mqProperty.getTopic(), mqProperty.getGroupName(), e);
        }
    }

    public abstract SendResult sendMessage(String topic, String tags, String keys, String messageText) throws RocketMqException;

    /**
     * 获取配置信息
     * @return
     */
    public abstract ProducerProperties getMqProperty();
}