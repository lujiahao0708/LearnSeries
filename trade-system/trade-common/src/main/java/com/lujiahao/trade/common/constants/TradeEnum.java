package com.lujiahao.trade.common.constants;

/**
 * @author lujiahao
 * @date 2018-06-07 下午2:15
 */
public class TradeEnum {
    public enum RetEnum {
        SUCCESS("1", "成功"),
        FAIL("-1", "失败"),
        ;

        private String code;
        private String desc;

        RetEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
