package com.lujiahao.canal.client.handler;


import com.lujiahao.canal.client.domain.bo.CanalEntryBO;

/**
 * 业务处理器
 * @author lujiahao
 * @date 2018/10/21
 */
public interface Handler {

    /**
     * 前置处理
     *
     * @param canalEntryBO
     * @return true表示会处理 false不处理
     */
    boolean beforeHandle(CanalEntryBO canalEntryBO);

    /**
     * 业务处理
     *
     * @param canalEntryBO
     */
    void handle(CanalEntryBO canalEntryBO);

    /**
     * 业务处理完成
     *
     * @param canalEntryBO
     */
    void afterComplete(CanalEntryBO canalEntryBO);

}
