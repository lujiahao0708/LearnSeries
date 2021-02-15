package com.lujiahao.service.queue;

import com.lujiahao.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Redis实现队列(具有持久化功能)
 * @author lujiahao
 * @date 2018-11-06 16:52
 */
@Service
public class RedisQueueService extends AbsQueueService implements QueueInterface {

    private volatile int count = 0;
    private String ip = "127.0.0.1";
    private String key = "timeFlag";
    private int expireTime = 2000;// redis中使用的是秒

    @Autowired
    private ESService esService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void push(String msgId, Object object) {
        try {
            redisTemplate.opsForHash().put(ip, msgId, object);
            LOGGER.info("[Redis实现队列][存入数据][msgId:{}]", msgId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean handleMessage() {
        return pop();
    }

    @Override
    public boolean pop() {
        while (running) {
            ++count;
            int saveSize = 0;
            try {
                Long size = redisTemplate.opsForHash().size(ip);
                Long expire = redisTemplate.getExpire(key);
                LOGGER.info("[Redis实现队列][task start running][hashSize:{},ttl:{}]", size, expire);
                if (size >= 1000 || expire < 0) {
                    BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(ip);
                    List<Object> values = hashOperations.values();
                    saveSize =  esService.batchInsertData(values);


                    if (hashOperations.size() != 0) {
                        Long delete = redisTemplate.opsForHash().delete(ip, hashOperations.keys().toArray());
                        LOGGER.info("[Redis实现队列][删除size:{}]", delete);
                    }

                    redisTemplate.opsForValue().set(key, "true", expireTime, TimeUnit.MILLISECONDS);
                }
            }catch (Exception e){
                LOGGER.error("[Redis实现队列][drain queues error]", e);
            } finally {
                LOGGER.info("[Redis实现队列][执行次数:{},队列长度:{},保存个数:{}", count, saveSize);
                saveSize = 0;
            }
        }
        return true;
    }
}
