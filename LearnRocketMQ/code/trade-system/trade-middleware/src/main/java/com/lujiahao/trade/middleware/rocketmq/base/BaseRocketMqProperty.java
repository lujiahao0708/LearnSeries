package com.lujiahao.trade.middleware.rocketmq.base;

import lombok.Data;

/**
 * Rocketmq基础配置类
 * @author lujiahao
 * @date 2018-01-19 上午10:56
 */
@Data
public class BaseRocketMqProperty {
    private String namesrvAddr;
    private String groupName;
    private String topic;
    private String tag;
    private int batchMaxSize;
    private String instanceName;

    private String keys;
}
