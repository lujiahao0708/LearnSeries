package com.lujiahao.springboot.elasticjob;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author lujiahao
 * @date 2018-01-26 下午4:18
 */
@Configuration
public class SimpleJobConfig {

    //默认每天0点10分开始统计
//    @Value("${job.default.cron}")
    private String defaultCron = "0/5 * * * * ?";
//    private String defaultCron = "0 10 0 * * ?";
//    @Value("${job.default.shardingTotalCount}")
    private int defaultShardTotal = 2;
//    @Value("${job.default.shardingItemParameters}")
    private String defaultShardPrams = "";

    @Resource
    private ZookeeperRegistryCenter regCenter;

    /*@Resource
    private JobEventConfiguration jobEventConfiguration;*/

    @Resource
    private StatsDeviceJob statsDeviceJob;



    //@Bean(initMethod = "init")
    @PostConstruct
    public void init() {
        //statsDeviceJob
        new SpringJobScheduler(statsDeviceJob, regCenter,
                getLiteJobConfiguration(statsDeviceJob.getClass(), defaultCron, defaultShardTotal, defaultShardPrams)).init();
    }


    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, final String cron, final int defaultShardTotal, final String defaultShardPrams) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(
                jobClass.getName(), cron, defaultShardTotal).shardingItemParameters(defaultShardPrams).build(), jobClass.getCanonicalName())).overwrite(true).build();
    }
}