package com.lujiahao.canal.client.cycle;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.lujiahao.canal.client.domain.bo.CanalEntryBO;
import com.lujiahao.canal.client.domain.constant.TraceConstant;
import com.lujiahao.canal.client.utils.UUIDUtil;
import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * canal client 抽象类
 * @author lujiahao
 * @date 2018/10/20
 */
public abstract class AbstractClientLifeCycle implements LifeCycle {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private volatile boolean running = false;

    protected static final String             SEP                = SystemUtils.LINE_SEPARATOR;
    protected static final String             DATE_FORMAT        = "yyyy-MM-dd HH:mm:ss.SSS";
    protected Thread.UncaughtExceptionHandler handler            = (t, e) -> logger.error("parse events has an error", e);
    protected Thread                          thread             = null;
    protected CanalConnector connector;
    protected String                   context_format     = null;
    protected String                   row_format         = null;
    protected String                   transaction_format = null;

    public AbstractClientLifeCycle() {
        context_format = SEP + "****************************************************" + SEP;
        context_format += "* Batch Id: [{}] ,count : [{}] , memsize : [{}] , Time : {}" + SEP;
        context_format += "* Start : [{}] " + SEP;
        context_format += "* End : [{}] " + SEP;
        context_format += "****************************************************" + SEP;

        row_format = SEP
                + "----------------> binlog[{}:{}] , name[{},{}] , eventType : {} ,tableName : {}, executeTime : {} , delay : {}ms"
                + SEP;

        transaction_format = SEP + "================> binlog[{}:{}] , executeTime : {} , delay : {}ms" + SEP;
    }

    @Override
    public void start() {
        this.connector = getConnector();
        if (this.connector == null) {
            logger.warn("未配置CanalConnector,不启动");
            return;
        }

        thread = new Thread(() -> process());

        thread.setUncaughtExceptionHandler(handler);
        thread.start();
        running = true;
    }

    @Override
    public boolean isStart() {
        return running;
    }

    @Override
    public void stop() {
        if (!running) {
            return;
        }

        running = false;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        MDC.remove("destination");
    }

    protected void process() {
        int batchSize = 5 * 1024;
        while (running) {
            try {
                MDC.put("destination", getDestination());
                connector.connect();
                connector.subscribe();
                while (running) {
                    try {
                        MDC.put(TraceConstant.TRACE_ID, UUIDUtil.uuidStrNo_());
                        // 获取指定数量的数据
                        Message message = connector.getWithoutAck(batchSize);
                        long batchId = message.getId();
                        int size = message.getEntries().size();
                        if (batchId == -1 || size == 0) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                logger.error("处理异常", e);
                            }
                        } else {
                            printSummary(message, batchId, size);
                            handles(message.getEntries());
                        }
                        // 提交确认
                        connector.ack(batchId);
                        logger.info("qck batchId:{}", batchId);
                        // 处理失败, 回滚数据
                        // connector.rollback(batchId);
                    } finally {
                        MDC.clear();
                    }
                }
            } catch (Exception e) {
                logger.error("process error!", e);
            } finally {
                connector.disconnect();
                MDC.remove("destination");
            }
        }
    }

    protected void handles(List<CanalEntry.Entry> entries) {
        for (CanalEntry.Entry entry : entries) {
            long executeTime = entry.getHeader().getExecuteTime();
            long delayTime = System.currentTimeMillis() - executeTime;

            if (entry.getEntryType() == CanalEntry.EntryType.ROWDATA) {
                CanalEntry.RowChange rowChage = null;
                try {
                    rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                } catch (Exception e) {
                    throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
                }

                CanalEntry.EventType eventType = rowChage.getEventType();
                if (eventType == CanalEntry.EventType.QUERY || rowChage.getIsDdl()) {
                    continue;
                }
                String tableName = entry.getHeader().getTableName();
                logger.info(row_format,
                        new Object[] { entry.getHeader().getLogfileName(),
                                String.valueOf(entry.getHeader().getLogfileOffset()), entry.getHeader().getSchemaName(),
                                entry.getHeader().getTableName(), eventType, tableName,
                                String.valueOf(entry.getHeader().getExecuteTime()), String.valueOf(delayTime) });

                for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                    CanalEntryBO canalEntryBO = new CanalEntryBO();
                    canalEntryBO.setRowData(rowData);
                    canalEntryBO.setTableName(tableName);
                    canalEntryBO.setEventType(eventType);
                    //业务处理
                    handle(canalEntryBO);
                }
            }
        }
    }

    private void printSummary(Message message, long batchId, int size) {
        long memsize = 0;
        for (CanalEntry.Entry entry : message.getEntries()) {
            memsize += entry.getHeader().getEventLength();
        }

        String startPosition = null;
        String endPosition = null;
        if (!CollectionUtils.isEmpty(message.getEntries())) {
            startPosition = buildPositionForDump(message.getEntries().get(0));
            endPosition = buildPositionForDump(message.getEntries().get(message.getEntries().size() - 1));
        }

        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        logger.info(context_format, new Object[] { batchId, size, memsize, format.format(new Date()), startPosition, endPosition });
    }

    protected String buildPositionForDump(CanalEntry.Entry entry) {
        long time = entry.getHeader().getExecuteTime();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return entry.getHeader().getLogfileName() + ":" + entry.getHeader().getLogfileOffset() + ":"
                + entry.getHeader().getExecuteTime() + "(" + format.format(date) + ")";
    }

    /**
     * 处理数据
     *
     * @param canalEntry
     */
    protected abstract void handle(CanalEntryBO canalEntry);

    /**
     * CanalConnector, 每个CanalConnector代表一个instance
     *
     * @return
     */
    protected abstract CanalConnector getConnector();

    /**
     * 获取实例名
     *
     * @return
     */
    protected abstract String getDestination();
}
