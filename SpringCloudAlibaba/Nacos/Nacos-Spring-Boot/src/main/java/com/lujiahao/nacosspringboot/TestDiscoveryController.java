package com.lujiahao.nacosspringboot;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 测试服务注册发现
 * @author lujiahao
 * @date 2020-10-10
 */
@RestController
public class TestDiscoveryController implements CommandLineRunner {

    /** 注入 Nacos 的 NamingService 实例 **/
    @NacosInjected
    private NamingService namingService;

    /** 根据服务名称获取服务信息 **/
    @GetMapping(value = "getServerByName")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        final List<Instance> allInstances = namingService.getAllInstances(serviceName);
        return allInstances;
    }

    /** 需要实现 CommandLineRunner 接口 **/
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private Integer serverPort;
    @Override
    public void run(String... args) throws Exception {
        // 通过Naming服务注册实例到注册中心
        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
    }
}