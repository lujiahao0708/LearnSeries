package com.lujiahao.trade.common.rocketmq;

/**
 * 消费者的统一接口
 * @author lujiahao
 * @date 2018-01-19 上午10:58
 */
public interface IConsumer {

    /**
     * 启动消费者
     */
    void start();

    /**
     * 关闭消费者
     */
    void stop();
}
