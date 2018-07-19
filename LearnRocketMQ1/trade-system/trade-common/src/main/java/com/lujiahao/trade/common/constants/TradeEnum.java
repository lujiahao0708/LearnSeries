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

    public enum OrderStatusEnum {
        NO_CONFIRM("0", "未确认"),
        CONFIRM("1", "已确认"),
        CANCEL("2", "已取消"),
        INVALID("3", "已失效"),
        RETURNED("4", "退货"),
        ;

        private String statusCode;
        private String desc;

        OrderStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum PayStatusEnum {
        NO_PAY("0", "未支付"),
        PAYING("1", "支付中"),
        PAID("2", "已付款"),
        ;

        private String statusCode;
        private String desc;

        PayStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum ShippingStatusEnum {
        NO_SHIP("0", "未发货"),
        SHIPPED("1", "已发货"),
        RECEIVED("2", "已收货"),
        ;

        private String statusCode;
        private String desc;

        ShippingStatusEnum(String statusCode, String desc) {
            this.statusCode = statusCode;
            this.desc = desc;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum YesNoEnum {
        NO("0", "否"),
        YES("1", "是"),
        ;

        private String code;
        private String desc;

        YesNoEnum(String code, String desc) {
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

    public enum UserMonyLogTypeEnum {
        PAID("1", "订单付款"),
        REFUND("2", "订单退款"),
        ;

        private String code;
        private String desc;

        UserMonyLogTypeEnum(String code, String desc) {
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
