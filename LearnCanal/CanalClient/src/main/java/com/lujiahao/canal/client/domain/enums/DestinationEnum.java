package com.lujiahao.canal.client.domain.enums;

/**
 * canal实例instance名称
 * @author lujiahao
 * @date 2018/10/21
 */
public enum DestinationEnum {
    /**新的数据库地址*/
    EXAMPLE("example"),
    ;


    DestinationEnum(String destination) {
        this.destination = destination;
    }

    private String destination;

    public String getDestination() {
        return destination;
    }
}
