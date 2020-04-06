package com.lujiahao.trade.middleware.rocketmq;

import com.lujiahao.trade.middleware.rocketmq.base.AbstractRocketMqConsumer;
import com.lujiahao.trade.middleware.rocketmq.base.ConsumerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lujiahao
 * @date 2018-01-08 下午9:47
 */
@Component
public class TradeConsumer extends AbstractRocketMqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeConsumer.class);

    @Autowired
    private ConsumerProperties consumerProperties;

    @Override
    public ConsumerProperties getMqProperty() {
        return consumerProperties;
    }

    @Override
    public void handleMessage(String message, String msgId) {
        try {
            System.out.println("=========>" + message);
        } catch (Exception e) {
            LOGGER.error("消息处理 异常", e);
        }
    }
}
