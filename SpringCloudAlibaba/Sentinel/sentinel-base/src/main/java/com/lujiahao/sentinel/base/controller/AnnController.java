package com.lujiahao.sentinel.base.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnController {

    @SentinelResource(value = "ann", blockHandler = "exceptionHandler")
    @GetMapping("/ann")
    public String ann() {
        return "Hello Sentinel!";
    }

    // blockHandler函数，原方法调用被限流/降级/系统保护的时候调用
    public String exceptionHandler(BlockException ex) {
        ex.printStackTrace();
        return "System busy!";
    }
}
