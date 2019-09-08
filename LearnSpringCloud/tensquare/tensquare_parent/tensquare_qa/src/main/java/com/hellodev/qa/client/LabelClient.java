package com.hellodev.qa.client;

import com.hellodev.common.entity.Result;
import com.hellodev.qa.client.impl.LabelClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lujiahao
 * @date 2019-09-08 20:20
 */
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)
public interface LabelClient {

    @RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}