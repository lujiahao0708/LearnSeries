package com.lujiahao.springbootrediscluster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Redis集群配置
 * @author lujiahao
 * @date 2017-12-07 下午3:26
 */
@Configuration
public class RedisClusterConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String clusterAddress;

    @Bean
    public JedisCluster getJedisCluster() {
        // 分隔节点地址
        String[] cNodes = clusterAddress.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        for (String node : cNodes) {
            String[] hostAndPort = node.split(":");
            hostAndPortSet.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
        }
        // 创建JedisCluster对象
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet);

        return jedisCluster;
    }
}
