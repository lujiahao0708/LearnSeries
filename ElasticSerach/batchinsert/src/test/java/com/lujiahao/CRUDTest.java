package com.lujiahao;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-10-24 14:32
 */
public class CRUDTest extends BaseServletTest {
//    @Autowired
//    private GoodsRepository goodsRepository;
//
//    //http://localhost:8888/save
//    @Test
//    public void save() {
//        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
//                "商品" + System.currentTimeMillis(), "这是一个测试商品");
//        GoodsInfo save = goodsRepository.save(goodsInfo);
//        System.out.println(save);
//    }

    // TODO 明天下载这个kibana https://artifacts.elastic.co/downloads/kibana/kibana-5.5.2-linux-x86_64.tar.gz

    @Test
    public void batchSave() {
        try {
            //设置集群名称
            Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
            //创建client
            @SuppressWarnings("resource")
            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
            //写入数据
            System.out.println("123");
            // createDate(client);
            //搜索数据
//            GetResponse response = client.prepareGet("testgoods", "goods", "SCH30761").execute().actionGet();
//            输出结果
//            System.out.println(response.getSource());
            Map<String, Object> map = new HashMap<>();
            map.put("test","123");
            long startTimeall = System.currentTimeMillis();
            for (int i = 100; i < 200; i++) {
                long startTime = System.currentTimeMillis();
//                createManyDates(client, response.getSource(), i);
                createManyDates(client, map, i);
                long endTime = System.currentTimeMillis(); // 获取结束时间
                System.out.println("十万条插入时间： " + (endTime - startTime) + "ms");
            }
            long endTimeall = System.currentTimeMillis(); // 获取结束时间
            System.out.println("所有运行时间： " + (endTimeall - startTimeall) + "ms");

            //关闭client
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量插入（每次插入100000条）
     * @param client
     * @param map
     * @param j
     */
    public void createManyDates(TransportClient client, Map<String, Object> map, Integer j){
        int count = (j*100000+1);
        int k = j*100000;
        String index = "testgoods";
        String type = "goods";
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(int i = (j-1)*100000+1;i <count;i++){
            map.put("bdcqzh", i);
            //Map<String, Object> map = new HashMap<String, Object>();
            bulkRequestBuilder.add(client.prepareIndex(index, type, i+"").setSource(map));
            if(i%k ==0){
                bulkRequestBuilder.execute().actionGet();
            }
        }

    }


}
