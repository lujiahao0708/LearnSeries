package com.lujiahao.springboot.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2018-01-26 下午4:19
 */
@Service
public class StatsDeviceJob implements SimpleJob {
    private static Logger logger = LoggerFactory.getLogger(StatsDeviceJob.class);

    /**
     * 1.当分片数为1时,在同一个zookepper和jobname情况下,多台机器部署了Elastic job时,
     * 只有拿到shardingContext.getShardingItem()为0的机器得以执行,其他的机器不执行
     * 2.当分片数大于1时,假如有3台服务器，分成10片，则分片项分配结果为服务器A=0,1,2;服务器B=3,4,5;服务器C=6,7,8,9。
     * 此时每台服务器可根据拿到的shardingItem值进行相应的处理
     * 目前job分片数全部置为1,即不使用分片
     * @param shardingContext
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info(String.format("------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
        /**
         * 实际开发中，有了任务总片数和当前分片项，就可以对任务进行分片执行了
         * 比如 SELECT * FROM user WHERE status = 0 AND MOD(id, shardingTotalCount) = shardingItem
         */
    }
}
