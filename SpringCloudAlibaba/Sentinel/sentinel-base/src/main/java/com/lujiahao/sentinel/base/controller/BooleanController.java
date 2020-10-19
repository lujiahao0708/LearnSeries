package com.lujiahao.sentinel.base.controller;

import com.alibaba.csp.sentinel.SphO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lujiahao
 * @date 2020-10-08
 */
@RestController
public class BooleanController {

    @GetMapping("/boolean")
    public String booleanMethod() {
        if (SphO.entry("boolean")) {
            try {
                //被保护的资源
                return "Hello Sentinel boolean";
            } finally {
                // SphO.entry(xxx)需要与 SphO.exit()方法成对出现，
                // 否则会导致调用链记录异常，抛出ErrorEntryFreeException异常
                SphO.exit();//限流出口
            }
        } else {
            //被限流或者降级的处理
            return "System busy!";
        }
    }
}
