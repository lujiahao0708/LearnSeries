package com.lujiahao.bootstrap;

/**
 * 生命周期管理
 * @author lujiahao
 * @date 2018/10/20
 */
public interface LifeCycle {
    /**
     * 启动
     * @return
     */
    void start();

    /**
     * 停止
     * @return
     */
    void stop();

    /**
     * 是否启动
     *
     * @return true已启动 false未启动
     */
    boolean isStart();
}
