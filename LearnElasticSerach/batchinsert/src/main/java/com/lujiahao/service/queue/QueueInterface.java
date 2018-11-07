package com.lujiahao.service.queue;

/**
 * 队列接口
 * @author lujiahao
 * @date 2018-11-06 15:59
 */
public interface QueueInterface {

    boolean pop();

    void push(String msgId, Object object);
}
