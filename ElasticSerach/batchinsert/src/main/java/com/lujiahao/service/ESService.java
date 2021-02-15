package com.lujiahao.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-11-06 15:53
 */
@Service
public class ESService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ESService.class);

    @Autowired
    private TransportClient client;

    /**
     * 批量添加数据
     */
    public int batchInsertData(List<Object> dataList) throws Exception {
        LOGGER.info("[批量添加数据][队列满或者时间到,开始存入数据]");
        if (CollectionUtils.isEmpty(dataList)) {
            LOGGER.info("[批量添加数据][dataList is null or dataList.size = 0][跳出添加逻辑]");
            return 0;
        }
        int saveDataSize = 0;
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (Object data : dataList) {
            String index = createIndex();
            Map mapObj = JSONObject.parseObject(data.toString() ,Map.class);
            BulkRequestBuilder order_type = bulkRequest.add(client.prepareIndex(index, "order_type").setSource(mapObj));
            saveDataSize = order_type.numberOfActions();
        }
        long tookInMillis = bulkRequest.get().getTookInMillis();
        LOGGER.info("[批量添加数据][saveDataSize:{},耗时:{}ms]", saveDataSize, tookInMillis);
        return saveDataSize;
    }

    // 按分钟创建索引   后续改成按天创建索引
    private String createIndex() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String format = sdf.format(new Date());
        String index = "order_" + format;
        return index;
    }
}
