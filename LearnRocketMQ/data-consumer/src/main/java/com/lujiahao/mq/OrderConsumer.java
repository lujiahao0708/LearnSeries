package com.lujiahao.mq;

import com.alibaba.fastjson.JSON;
import com.lujiahao.bo.OrderBO;
import com.lujiahao.config.BaseRocketMqProperty;
import com.lujiahao.config.OrderConfig;
import com.lujiahao.constant.TraceConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订阅CarFactOrder的topic
 * @author lujiahao
 * @date 2018/11/1
 */
@Component
public class OrderConsumer extends AbstractRocketMqConsumer {

    @Autowired(required = false)
    private OrderConfig orderConfig;


    @Override
    public boolean handleMessage(String message, String msgId) {
        if (StringUtils.isBlank(message)) {
            return true;
        }

        OrderBO order = JSON.parseObject(message, OrderBO.class);
        MDC.put(TraceConstant.ORDER_NO, order.getOrderNo());
        logger.info("消费者开始处理 order:[{}]", order);
        return true;
    }

    @Override
    public BaseRocketMqProperty getMqProperty() {
        return orderConfig;
    }
}
