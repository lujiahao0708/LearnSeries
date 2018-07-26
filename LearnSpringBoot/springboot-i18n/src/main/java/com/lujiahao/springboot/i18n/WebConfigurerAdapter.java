package com.lujiahao.springboot.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author lujiahao
 * @date 2018/7/26
 */
@Configuration
public class WebConfigurerAdapter extends WebMvcConfigurerAdapter {

    /** 国际化相关 */
    @Bean
    public LocaleResolver localeResolver() {
        return new I18nLocaleResolver();
    }

    /**
     * 如果出现中文乱码可以使用下面的配置
     * 解决中文乱码
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
}
