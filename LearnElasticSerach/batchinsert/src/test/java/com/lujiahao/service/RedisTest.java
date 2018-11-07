package com.lujiahao.service;

import com.lujiahao.BaseServletTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RedisTest extends BaseServletTest {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void buildIndex() {
//        redisTemplate.opsForValue().set("lujiahao","lujiahao");
//        String name = redisTemplate.opsForValue().get("lujiahao");//根据key获取缓存中的val
//        System.out.println();

        String key = "timeFlag";
        redisTemplate.opsForValue().set(key, "true", 100, TimeUnit.SECONDS);
        while (true) {
            Long expire = redisTemplate.getExpire(key);
            System.out.println(expire);
        }
    }
}