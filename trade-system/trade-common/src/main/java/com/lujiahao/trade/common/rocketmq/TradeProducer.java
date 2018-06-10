package com.lujiahao.trade.common.rocketmq;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.lujiahao.trade.common.rocketmq.base.AbstractRocketMqProducer;
import com.lujiahao.trade.common.exception.RocketMqException;
import com.lujiahao.trade.common.rocketmq.base.ProducerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lujiahao
 * @date 2018-06-06 下午1:32
 */
@Component
public class TradeProducer extends AbstractRocketMqProducer {

    @Autowired
    private ProducerProperties producerProperties;

    @Override
    public SendResult sendMessage(String topic, String tags, String keys, String messageText) throws RocketMqException {
        Message message = new Message(topic, tags, keys, messageText.getBytes());
        try {
            SendResult sendResult = this.producer.send(message);
            return sendResult;
        } catch (Exception e) {
            throw new RocketMqException(e);
        }
    }

    @Override
    public ProducerProperties getMqProperty() {
        return producerProperties;
    }

    public void send(String messageText) {
        try {
            SendResult sendResult = this.sendMessage(producerProperties.getTopic(), producerProperties.getTag(), producerProperties.getKeys(), messageText);
        } catch (RocketMqException e) {
            e.printStackTrace();
        }
    }

}
