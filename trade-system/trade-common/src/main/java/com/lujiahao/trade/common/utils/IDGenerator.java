package com.lujiahao.trade.common.utils;

import java.util.UUID;

/**
 * @author lujiahao
 * @date 2018-06-12 下午11:02
 */
public class IDGenerator {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
