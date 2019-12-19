package com.lujiahao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author lujiahao
 * @date 2019-09-25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private AuthInterceptor authInterceptor;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login","/doAJAXLogin","/error","/bootstrap/**","/css/**","/fonts/**","/img/**","/jquery/**","/layer/**","/script/**","/ztree/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login","/doAJAXLogin","/error","/bootstrap/**","/css/**","/fonts/**","/img/**","/jquery/**","/layer/**","/script/**","/ztree/**");
    }
}
