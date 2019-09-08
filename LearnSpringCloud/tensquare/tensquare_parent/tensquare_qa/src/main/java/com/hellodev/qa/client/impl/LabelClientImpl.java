package com.hellodev.qa.client.impl;

import com.hellodev.common.entity.Result;
import com.hellodev.common.entity.StatusCode;
import com.hellodev.qa.client.LabelClient;
import org.springframework.stereotype.Component;

/**
 * @author lujiahao
 * @date 2019-09-08 22:01
 */
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR.getCode(), "熔断器启动了");
    }
}