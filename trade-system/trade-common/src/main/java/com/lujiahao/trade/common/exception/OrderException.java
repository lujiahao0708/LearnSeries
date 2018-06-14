package com.lujiahao.trade.common.exception;

/**
 * @author lujiahao
 * @date 2018-06-12 下午10:08
 */
public class OrderException extends RuntimeException {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
