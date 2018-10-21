package com.lujiahao.canal.client.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lujiahao.canal.client.cycle.AbstractClientLifeCycle;
import com.lujiahao.canal.client.domain.bo.CanalEntryBO;
import com.lujiahao.canal.client.domain.enums.DestinationEnum;
import com.lujiahao.canal.client.handler.HandlerChain;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * 单机客户端
 * @author lujiahao
 * @date 2018/10/21
 */
@Component
public class SingleClient extends AbstractClientLifeCycle {

    @Resource
    private HandlerChain handlerChain;

    @Value("${canal_config.host_name}")
    private String hostName;
    @Value("${canal_config.port}")
    private int port;
    @Value("${canal_config.username}")
    private String userName;
    @Value("${canal_config.password}")
    private String password;


    @Override
    protected void handle(CanalEntryBO canalEntry) {

        if (canalEntry.getEventType() != CanalEntry.EventType.INSERT && canalEntry.getEventType() != CanalEntry.EventType.UPDATE) {
            return;
        }

        canalEntry.setDestinationEnum(DestinationEnum.EXAMPLE);
        handlerChain.handle(canalEntry);
    }

    @Override
    protected CanalConnector getConnector() {
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress(hostName, port), DestinationEnum.EXAMPLE.getDestination(), userName, password);
        logger.info("instance:{} 准备启动", DestinationEnum.EXAMPLE.getDestination());
        return connector;
    }

    @Override
    protected String getDestination() {
        return DestinationEnum.EXAMPLE.getDestination();
    }
}
