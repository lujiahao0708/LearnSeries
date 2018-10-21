package com.lujiahao.canal.client.handler.table;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lujiahao.canal.client.domain.bo.CanalEntryBO;
import com.lujiahao.canal.client.domain.bo.TestTableParserBO;
import com.lujiahao.canal.client.domain.bo.TraceItemBO;
import com.lujiahao.canal.client.domain.constant.TableConstant;
import com.lujiahao.canal.client.domain.constant.TraceConstant;
import com.lujiahao.canal.client.handler.AbstractHandler;
import com.lujiahao.canal.client.mq.RocketMqProducer;
import com.lujiahao.canal.client.service.TableParserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 具体某个表相关处理
 * @author lujiahao
 * @date 2018/10/20
 */
@Component
public class TestTableHandler extends AbstractHandler {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

//    @Resource(name = "testCanalProducer")
//    private RocketMqProducer testCanalProducer;
    @Autowired
    private TableParserService tableParserService;

    @Override
    public boolean beforeHandle(CanalEntryBO canalEntryBO) {
        if (canalEntryBO == null) {
            return false;
        }
        boolean handle = canalEntryBO.getEventType() == CanalEntry.EventType.UPDATE || canalEntryBO.getEventType() == CanalEntry.EventType.INSERT;
        return handle && TableConstant.TEST.equals(canalEntryBO.getTableName());
    }

    @Override
    public void handle(CanalEntryBO canalEntryBO) {
        TraceItemBO itemBO = TraceItemBO.createByCurrentMDC();
        try {
            TestTableParserBO testTableParserBO = tableParserService.analysisColumn(canalEntryBO.getRowData().getAfterColumnsList());
            //itemBO.setOrderNo(vipOrderParserStr.getOrderNo());
            itemBO.setTableName(canalEntryBO.getTableName());
            itemBO.putALl();
            // 此处rocketmq的tag
            // String tag = vipOrderParserStr.getType() + "_" + vipOrderParserStr.getStatus();

//            if (canalEntryBO.getEventType() == CanalEntry.EventType.INSERT) {
//                vipOrderParserStr.setEventCategory(EventCategory.INSERT);
//            } else if (canalEntryBO.getEventType() == CanalEntry.EventType.UPDATE) {
//                vipOrderParserStr.setEventCategory(EventCategory.UPDATE);
//            }
//
//            String topic = TopicEnum.getTopic(canalEntryBO.getDestinationEnum(), TableConstant.TEST);
//            if (StringUtils.isBlank(topic)) {
//                logger.warn("未配置topic, 不处理 tableName:{}", TableConstant.TEST);
//                return;
//            }
//
//            StopWatch stopWatch = new Slf4JStopWatch();
//            boolean success = testCanalProducer.sendMessage(topic, tag,vipOrderParserStr.getOrderNo(), JSON.toJSONString(vipOrderParserStr));
//            stopWatch.stop(topic);
//            if (success) {
//                LogUtils.success(topic);
//            }
            LOGGER.info("数据库变化,testTableParserBO:{}", JSON.toJSONString(testTableParserBO));
        } finally {
            itemBO.removeAll();
        }
    }

    @Override
    public void afterComplete(CanalEntryBO canalEntryBO) {
        MDC.remove(TraceConstant.ORDER_NO);
    }

}
