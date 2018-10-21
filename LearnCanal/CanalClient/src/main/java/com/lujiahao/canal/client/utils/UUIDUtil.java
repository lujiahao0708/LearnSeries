package com.lujiahao.canal.client.utils;

import java.util.UUID;

/**
 * @author lujiahao
 * @date 2018-10-20 20:27
 */
public class UUIDUtil {

    public static String uuidStr() {
        return UUID.randomUUID().toString();
    }

    public static String uuidStrNo_() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
