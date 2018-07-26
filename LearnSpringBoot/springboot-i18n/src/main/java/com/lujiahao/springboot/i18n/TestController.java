package com.lujiahao.springboot.i18n;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lujiahao
 * @date 2018-07-17 上午11:41
 */
@RestController
public class TestController {

    // http://localhost:8080/?lang=zh
    // http://localhost:8080/?lang=en
    @GetMapping("/")
    public String test() {
        String msg = MessageManager.getMsg("message");
        return msg;
    }
}
