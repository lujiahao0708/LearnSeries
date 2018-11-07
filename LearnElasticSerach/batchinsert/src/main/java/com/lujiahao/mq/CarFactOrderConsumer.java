package com.lujiahao.mq;

import com.alibaba.fastjson.JSON;
import com.lujiahao.service.queue.QueueInterface;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订阅的topic
 * @author lujiahao
 * @date 2018/11/1
 */
@Component
public class CarFactOrderConsumer extends AbstractRocketMqConsumer {

    @Autowired
    private CarFactOrderConfig carFactOrderConfig;

    @Autowired
    private QueueInterface queueInterface;

    @Override
    public boolean handleMessage(String message, String msgId) {
        if (StringUtils.isBlank(message)) {
            return true;
        }

        OrderBO order = JSON.parseObject(message, OrderBO.class);
        MDC.put(TraceConstant.ORDER_NO, order.getOrderNo());
//        logger.info("订单消费者开始处理 message:[{}]", message);
        queueInterface.push(msgId, message);
        return true;
    }

    @Override
    public BaseRocketMqProperty getMqProperty() {
        return carFactOrderConfig;
    }
}
