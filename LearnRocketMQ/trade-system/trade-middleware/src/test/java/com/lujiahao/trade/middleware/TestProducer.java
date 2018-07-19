package com.lujiahao.trade.middleware;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.lujiahao.trade.common.constants.MQEnum;
import com.lujiahao.trade.common.exception.RocketMqException;
import com.lujiahao.trade.middleware.rocketmq.TradeProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Producer测试类
 * @author lujiahao
 * @date 2018-06-06 下午1:27
 */
public class TestProducer extends BaseTestCase {

    @Autowired
    private TradeProducer producer;

    @Test
    public void testProducer() throws RocketMqException {
        SendResult sendResult = producer.sendMessage(MQEnum.TopicEnum.ORDER_CANCEL, "lujiahao", "lujiahao");
        System.out.println(sendResult);
//        producer.send("lujiahao");
    }
}
