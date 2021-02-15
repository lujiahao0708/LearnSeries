package com.lujiahao.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象生命周期管理
 * @author lujiahao
 * @date 2018/11/5
 */
public abstract class AbstractLifeCycle implements LifeCycle {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
