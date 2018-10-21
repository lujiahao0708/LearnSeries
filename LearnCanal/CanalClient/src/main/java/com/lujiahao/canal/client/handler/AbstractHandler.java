package com.lujiahao.canal.client.handler;

import com.lujiahao.canal.client.utils.LogRejectedExecutionHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lujiahao
 * @date 2018/10/21
 */
public abstract class AbstractHandler implements Handler {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static ThreadPoolExecutor executor;
    static {
        executor = new ThreadPoolExecutor(10, 30, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20000), new
                LogRejectedExecutionHandler());
        executor.allowCoreThreadTimeOut(true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (executor != null) {
                executor.shutdown();
            }
        }));
    }

//    /**
//     * 根据订单号判断是否是预生产环境
//     *
//     * @return true表示预生产 false表示非预生产
//     */
//    protected boolean isOrderPre(String orderNo) {
//        if (StringUtils.isBlank(orderNo)) {
//            return false;
//        }
//        return orderNo.endsWith(ConfigConstant.ORDER_PRE_SUFFIX);
//    }
//
//    /**
//     * 发送预生产
//     */
//    protected void sendPreMessage(RocketMqProducer producer, String topic, String tag, String key, String value) {
//        final TraceItemBO itemBO = TraceItemBO.createByCurrentMDC();
//        executor.submit(() -> {
//            if (itemBO != null) {
//                itemBO.putALl();
//            }
//            try {
//                producer.sendMessage(topic, tag, key, value);
//            } finally {
//                itemBO.removeAll();
//            }
//        });
//    }
}
