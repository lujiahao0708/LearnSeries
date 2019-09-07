package com.hellodev.sms;

/**
 * @author lujiahao
 * @date 2019-09-07 17:42
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听类
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    /**
     * 发送短信
     */
    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        System.out.println("手机号:" + message.get("mobile"));
        System.out.println("验证码:" + message.get("code"));
    }
}
