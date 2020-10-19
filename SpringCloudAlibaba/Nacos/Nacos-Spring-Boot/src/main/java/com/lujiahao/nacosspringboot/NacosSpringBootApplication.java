package com.lujiahao.nacosspringboot;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
// 加载 dataId 为 example 的配置源，并开启自动更新
@NacosPropertySource(dataId = "springboot-config", autoRefreshed = true)
public class NacosSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosSpringBootApplication.class, args);
	}

	/** 注入 Nacos 的 NamingService 实例 **/
	@NacosInjected
	private NamingService namingService;

	/** 需要实现 CommandLineRunner 接口 **/
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${server.port}")
	private Integer serverPort;
//	@Override
//	public void run(String... args) throws Exception {
//		// 通过Naming服务注册实例到注册中心
//		namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
//	}
	@PostConstruct
	public void registerInstance() throws NacosException {
		namingService.registerInstance(applicationName,"127.0.0.1",serverPort);
	}
}
