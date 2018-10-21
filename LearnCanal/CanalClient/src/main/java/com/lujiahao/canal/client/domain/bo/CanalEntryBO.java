package com.lujiahao.canal.client.domain.bo;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lujiahao.canal.client.domain.enums.DestinationEnum;

/**
 * canal中的实体数据
 * @author lujiahao
 * @date 2018/10/20
 */
public class CanalEntryBO {
    private String tableName;
    private DestinationEnum destinationEnum;
    private CanalEntry.RowData rowData;
    CanalEntry.EventType eventType;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DestinationEnum getDestinationEnum() {
        return destinationEnum;
    }

    public void setDestinationEnum(DestinationEnum destinationEnum) {
        this.destinationEnum = destinationEnum;
    }

    public com.alibaba.otter.canal.protocol.CanalEntry.RowData getRowData() {
        return rowData;
    }

    public void setRowData(com.alibaba.otter.canal.protocol.CanalEntry.RowData rowData) {
        this.rowData = rowData;
    }

    public CanalEntry.EventType getEventType() {
        return eventType;
    }

    public void setEventType(CanalEntry.EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "CanalEntryBO{" +
                "tableName='" + tableName + '\'' +
                ", destinationEnum=" + destinationEnum +
                ", rowData=" + rowData +
                ", eventType=" + eventType +
                '}';
    }
}
