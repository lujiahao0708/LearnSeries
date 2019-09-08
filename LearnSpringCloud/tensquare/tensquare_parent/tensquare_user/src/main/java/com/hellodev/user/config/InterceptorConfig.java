package com.hellodev.user.config;

import com.hellodev.user.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author lujiahao
 * @date 2019-09-08 18:46
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器要声明拦截器对象和要拦截的请求
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login/**");
    }
}