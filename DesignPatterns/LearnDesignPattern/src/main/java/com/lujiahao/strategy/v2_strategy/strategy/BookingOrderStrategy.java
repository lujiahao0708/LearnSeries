package com.lujiahao.strategy.v2_strategy.strategy;

import com.lujiahao.strategy.OrderDTO;
import com.lujiahao.strategy.OrderTypeEnum;
import com.lujiahao.strategy.v2_strategy.OrderTypeAnnotation;
import org.springframework.stereotype.Service;

/**
 * 预约单处理逻辑
 * @author lujiahao
 * @date 2019-05-22 17:47
 */
@Service
@OrderTypeAnnotation(orderType = OrderTypeEnum.BOOKING)
public class BookingOrderStrategy extends AbstractStrategy {

    @Override
    public void process(OrderDTO orderDTO) {
        System.out.println("取消预约订单");
    }
}
