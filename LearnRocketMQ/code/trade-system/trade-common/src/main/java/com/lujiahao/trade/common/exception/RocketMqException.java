package com.lujiahao.trade.common.exception;

/**
 * @author lujiahao
 * @date 2018-06-05 下午1:51
 */
public class RocketMqException extends Exception{
    public RocketMqException() {
        super();
    }

    public RocketMqException(String message) {
        super(message);
    }

    public RocketMqException(String message, Throwable cause) {
        super(message, cause);
    }

    public RocketMqException(Throwable cause) {
        super(cause);
    }
}
