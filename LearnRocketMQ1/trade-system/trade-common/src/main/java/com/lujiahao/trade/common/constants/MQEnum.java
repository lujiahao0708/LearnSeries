package com.lujiahao.trade.common.constants;

/**
 * @author lujiahao
 * @date 2018-06-13 下午1:52
 */
public class MQEnum {
    public enum TopicEnum{
        ORDER_CONFIRM("ordeTopic", "confirm"),
        ORDER_CANCEL("orderTopic", "cancel"),
        PAY_PAID("payTopic", "paid"),
        ;

        private String topic;
        private String tag;

        TopicEnum(String topic, String tag) {
            this.topic = topic;
            this.tag = tag;
        }

        public String getTopic() {
            return topic;
        }

        public String getTag() {
            return tag;
        }
    }
}
