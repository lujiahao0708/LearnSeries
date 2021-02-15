package com.lujiahao.strategy.v1_original;

import com.lujiahao.strategy.OrderDTO;
import org.springframework.stereotype.Service;

/**
 * 取消订单处理逻辑
 * @author lujiahao
 * @date 2019-05-22 11:05
 */
@Service
public class CancelOrderService {

    /**
     * 处理取消逻辑
     */
    public void process(OrderDTO orderDTO) {
        int serviceType = orderDTO.getServiceType();

        if (1 == serviceType) {
            System.out.println("取消即时订单");
        } else if (2 == serviceType) {
            System.out.println("取消预约订单");
        } else if (3 == serviceType) {
            System.out.println("取消拼车订单");
        }
    }
}
