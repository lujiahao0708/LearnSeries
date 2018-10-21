package com.lujiahao.canal.client.domain.bo;

import com.lujiahao.canal.client.domain.constant.TraceConstant;
import lombok.Data;
import org.slf4j.MDC;

/**
 * 日志追踪实体
 * @author lujiahao
 * @date 2018/10/21
 */
@Data
public class TraceItemBO {
    private String traceId;
    private String orderNo;
    private String tableName;

    public TraceItemBO(String traceId, String orderNo, String tableName) {
        this.tableName = tableName;
        this.traceId = traceId;
        this.orderNo = orderNo;
    }

    /**
     * 基于当前MDC创建item
     *
     * @return
     */
    public static TraceItemBO createByCurrentMDC() {
        return new TraceItemBO(MDC.get(TraceConstant.TRACE_ID), MDC.get(TraceConstant.ORDER_NO), MDC.get(TraceConstant.TABLE_NAME));
    }

    /**
     * 往当前线程的MDC中放值
     */
    public void putALl() {
        MDC.put(TraceConstant.TRACE_ID, getTraceId());
        MDC.put(TraceConstant.ORDER_NO, getOrderNo());
        MDC.put(TraceConstant.TABLE_NAME, getTableName());
    }

    /**
     * 移除MDC中的值
     */
    public void removeAll() {
        MDC.remove(TraceConstant.TRACE_ID);
        MDC.remove(TraceConstant.ORDER_NO);
        MDC.remove(TraceConstant.TABLE_NAME);
    }
}
