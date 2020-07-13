package com.lujiahao.concurrent.chapter08;

/**
 * 任务队列无法接受新任务异常
 * @author lujiahao
 * @date 2019-11-26
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
