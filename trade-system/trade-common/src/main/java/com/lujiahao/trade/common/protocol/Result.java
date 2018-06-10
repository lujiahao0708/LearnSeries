package com.lujiahao.trade.common.protocol;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2018-06-07 下午1:53
 */
@Data
public class Result<T> {
    private String retCode;
    private String retInfo;
    private T data;
}
