package com.lujiahao;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseServletTest {
//    static {
//        System.setProperty("spring.profiles.active", "dev");
//    }
    @Test
    public void test() {
        System.out.println("test...");
    }

    @Autowired
    private TransportClient client;

    public void testData() throws Exception{
//        Settings settings = Settings.settingsBuilder().put("docker-cluster", "elasticsearch").build();
//        TransportClient client = TransportClient.builder().settings(settings).build();
//        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("bigdata2"), 9300));

        //client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        Long count = 100000L;
        String index = "bigdata";
        String type = "student1";
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (int i = 0; i < count; i++) {
            Map<String, Object> ret = new HashMap<String, Object>();
            ret.put("recordtime", 11);
            ret.put("area", 22);
            ret.put("usertype", 33);
            ret.put("count", 44);
            bulkRequest.add(client.prepareIndex(index, type).setSource(ret));
            // 每10000条提交一次
            if (i % 10000 == 0) {
                bulkRequest.execute().actionGet();
                bulkRequest = client.prepareBulk();
            }
            bulkRequest.execute().actionGet();
        }
    }
}
