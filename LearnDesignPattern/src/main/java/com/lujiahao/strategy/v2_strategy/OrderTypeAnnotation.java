package com.lujiahao.strategy.v2_strategy;

import com.lujiahao.strategy.OrderTypeEnum;

import java.lang.annotation.*;

/**
 * 订单类型注解
 * @author lujiahao
 * @date 2019-05-22 16:58
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrderTypeAnnotation {
    OrderTypeEnum orderType();
}
