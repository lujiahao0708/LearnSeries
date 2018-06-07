package com.lujiahao.trade.common;

import com.lujiahao.trade.common.rocketmq.TradeProducer;
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
    public void testProducer() {
        producer.send("lujiahao");
    }
}
