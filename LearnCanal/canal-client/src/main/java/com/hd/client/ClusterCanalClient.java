package com.hd.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.Message;
import com.hd.config.ClusterCanalConfig;
import com.hd.domain.CommonMessage;
import com.hd.utils.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 集群 canal 客户端
 *
 * @author lujiahao
 * @date 2020-08-25
 */
@Slf4j
@Component
public class ClusterCanalClient implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClusterCanalConfig clusterCanalConfig;

    private CanalConnector clusterCanalConnector;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent == null) {
            return;
        }

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (null == applicationContext || null != applicationContext.getParent()) {
            return;
        }
        // 注册钩子函数,JVM 关闭时正确释放资源
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
        // 启动 client
        this.start();
    }

    private void start() {
        try {
            // 获取并连接 client
            clusterCanalConnector = this.getCanalConnector();
            // 轮询拉取数据
            int batchSize = 5 * 1024;
            while (true) {
                Message message = clusterCanalConnector.getWithoutAck(batchSize);
                long id = message.getId();
                int size = message.getEntries().size();
                log.info("集群--->当前监控到binLog消息数量:{}", size);
                if (id == -1 || size == 0) {
                    // 无消息休眠 1s
                    TimeUnit.MILLISECONDS.sleep(1000L);
                } else {
                    this.handleMessage(message);
                    clusterCanalConnector.ack(id);
                }
            }
        } catch (Exception e) {
            log.error("启动异常", e);
        }
    }

    private CanalConnector getCanalConnector() {
        clusterCanalConnector = CanalConnectors.newClusterConnector(clusterCanalConfig.getZkServers(),
                clusterCanalConfig.getDestination(), clusterCanalConfig.getUsername(), clusterCanalConfig.getPassword());
        //连接CanalServer & 订阅destination
        clusterCanalConnector.connect();
        clusterCanalConnector.subscribe(clusterCanalConfig.getFilter());
        return clusterCanalConnector;
    }

    private void handleMessage(Message message) {
        List<CommonMessage> commonMessageList = MessageUtil.convert(message);
        for (CommonMessage commonMessage : commonMessageList) {
            log.info("操作表名:{},执行操作:{},操作数据:{}", commonMessage.getTable(), commonMessage.getType(), commonMessage.getData());
        }
    }

    private void stop() {
        //关闭连接CanalServer
        clusterCanalConnector.disconnect();
        // 注销订阅destination
        clusterCanalConnector.unsubscribe();
        log.info("canal client stop......");
    }
}