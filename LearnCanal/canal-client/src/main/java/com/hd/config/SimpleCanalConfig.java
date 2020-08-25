package com.hd.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * 单节点配置
 * @author lujiahao
 * @date 2020-08-25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "canal.simple")
public class SimpleCanalConfig implements Serializable {
    private static final long serialVersionUID = 5383651205818326893L;

    private String serverIp;
    private Integer serverPort;
    private String username;
    private String password;
    private String destination;
    private String filter;
}
