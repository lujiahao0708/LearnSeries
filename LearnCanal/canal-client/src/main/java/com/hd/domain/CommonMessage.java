package com.hd.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class CommonMessage implements Serializable {

    private static final long serialVersionUID = 2611556444074013268L;

    /**
     * 数据库或schema
     **/
    private String database;
    /**
     * 表名
     **/
    private String table;
    private List<String> pkNames;
    private Boolean isDdl;
    /**
     * 类型:INSERT/UPDATE/DELETE
     **/
    private String type;
    /**
     * binlog executeTime, 执行时间
     **/
    private Long es;
    /**
     * dml build timeStamp, 同步时间
     **/
    private Long ts;
    /**
     * 执行的sql,dml sql为空
     **/
    private String sql;
    /**
     * 数据列表
     **/
    private List<Map<String, Object>> data;
    /**
     * 旧数据列表,用于update,size和data的size一一对应
     **/
    private List<Map<String, Object>> old;


    public void clear() {
        database = null;
        table = null;
        type = null;
        ts = null;
        es = null;
        data = null;
        old = null;
        sql = null;
    }

}
