package com.lujiahao.springbootredisspringsession;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author lujiahao
 * @date 2017-12-08 下午6:31
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
// maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，
// 原Boot的server.session.timeout属性不再生效
public class SessionConfig {
}
