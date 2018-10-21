package com.lujiahao.canal.client.handler;


import com.lujiahao.canal.client.domain.bo.CanalEntryBO;

/**
 * 处理链
 * @author lujiahao
 * @date 2018/10/20
 */
public interface HandlerChain {

    /**
     * 业务处理
     *
     * @param canalEntryBO
     */
    void handle(CanalEntryBO canalEntryBO);

    /**
     * 添加处理器
     *
     * @param handler
     */
    void addHandler(Handler handler);
}
