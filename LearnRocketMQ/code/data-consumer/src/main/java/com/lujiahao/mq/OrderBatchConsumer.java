package com.lujiahao.mq;

import com.alibaba.fastjson.JSON;
import com.lujiahao.bo.OrderBO;
import com.lujiahao.config.BaseRocketMqProperty;
import com.lujiahao.config.OrderBatchConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 订阅CarFactOrder的topic 批量消费
 */
@Component
public class OrderBatchConsumer extends AbstractRocketMqBatchConsumer {

    @Autowired(required = false)
    private OrderBatchConfig orderBatchConfig;

    @Override
    public boolean handleBatchMessage(List<MessageExt> batchMsg) {
        List<OrderBO> orderBOList = new ArrayList<>();
        for (int i = 0; i < batchMsg.size(); i++) {
            MessageExt msgExt = batchMsg.get(i);
            String msgId = msgExt.getMsgId();
            String msgBody = new String(msgExt.getBody());
            if (StringUtils.isBlank(msgBody)) {
                logger.warn("[CarFactOrderBatchConsumer:handleBatchMessage][msgBody is blank][msgId:{}]", msgId);
                continue;
            }
            OrderBO orderBO = JSON.parseObject(msgBody, OrderBO.class);
            orderBOList.add(orderBO);
        }
        logger.info("[CarFactOrderBatchConsumer:handleBatchMessage][msgSize:{}, orderBOListSize:{}, orderBOListSize:{}]",
                batchMsg.size(), orderBOList.size(), orderBOList);
        return true;
    }

    @Override
    public BaseRocketMqProperty getMqProperty() {
        return orderBatchConfig;
    }


}
