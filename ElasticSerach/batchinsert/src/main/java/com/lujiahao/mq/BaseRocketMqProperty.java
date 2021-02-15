package com.lujiahao.mq;

import lombok.Data;

/**
 *
 * @author lujiahao
 * @date 2018/11/1
 */
@Data
public class BaseRocketMqProperty {
    private String namesrvAddr;
    private String groupName;
    private String topic;
    private String tag;
    private int batchMaxSize = 16;
    private String instanceName;
}
