package com.hd.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * 集群配置
 * @author lujiahao
 * @date 2020-08-25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "canal.cluster")
public class ClusterCanalConfig implements Serializable {
    private static final long serialVersionUID = -7504790037432002179L;
    private String username;
    private String password;
    private String destination;
    private String filter;
    private String zkServers;
}
