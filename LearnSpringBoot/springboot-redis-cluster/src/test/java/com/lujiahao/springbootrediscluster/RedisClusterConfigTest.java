package com.lujiahao.springbootrediscluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterConfigTest {
    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test(){
        jedisCluster.set("a","haha");
        String ping = jedisCluster.get("a");
        System.out.println("=======>" + ping);
    }
}