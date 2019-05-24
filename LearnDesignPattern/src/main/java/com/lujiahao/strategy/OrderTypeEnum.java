package com.lujiahao.strategy;

/**
 * 订单类型枚举
 * @author lujiahao
 * @date 2019-05-22 15:12
 */
public enum OrderTypeEnum {
    INSTANT(1, "即时订单"),
    BOOKING(2, "预约订单"),
    CARPOOL(3, "拼车订单");

    private int code;
    private String desc;

    OrderTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**根据value返回枚举类型,主要在switch中使用*/
    public static OrderTypeEnum getByCode(int code) {
        for (OrderTypeEnum orderTypeEnum : values()) {
            if (orderTypeEnum.getCode() == code) {
                return orderTypeEnum;
            }
        }
        return null;
    }
}
