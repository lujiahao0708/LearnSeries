//package com.lujiahao.queue;
//
//import com.google.common.collect.Queues;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.*;
//
///**
// * @author lujiahao
// * @date 2018-10-31 23:37
// */
//public class LogsConsumer implements Runnable{
//
//    /** 日志 **/
//    private static final Logger LOGGER = LoggerFactory.getLogger(LogsConsumer.class);
//
//    private volatile boolean isRunning = true;
//
//    private volatile int count = 0;
//
//    private BlockingQueue queue;
//
//    public LogsConsumer(BlockingQueue queue) {
//        this.queue = queue;
//    }
//
//    /**
//     * 消费者
//     */
//    public void run() {
//        while (isRunning) {
//            ++count;
//            try {
//                LOGGER.info("task running");
//                //每次取出的数据存放到logsDatas里
//                List<String> logsDatas = new ArrayList<String>();
//                //每次到1000条数据才进行入库，等待1分钟，没达到1000条也继续入库
////                Queues.drain(queue, logsDatas, 1000, 1, TimeUnit.MINUTES);
//                Queues.drain(queue, logsDatas, 2, 10, TimeUnit.SECONDS);
//                this.insertData(logsDatas);
//            }catch (Exception e){
//                LOGGER.error("LogsConsumer drain queues error:",e);
//            } finally {
//                LOGGER.info("执行次数:" + count);
//            }
//        }
//    }
//
//    /**
//     *批量添加方法
//     * @param logsDatas
//     */
//    private void insertData(List<String> logsDatas) throws Exception {
//        LOGGER.info("队列满/时间到,开始执行取队列数据方法(存入es),logsData:" + logsDatas.size());
//        if (!CollectionUtils.isEmpty(logsDatas)){
////            Client client = ElasticsearchClientUtil.getClient();
////            BulkRequestBuilder bulkRequest = client.prepareBulk();
////            for (String logsData:logsDatas){
////                bulkRequest.add(client.prepareIndex("statistics", "pvanduv").setSource(logsData));
////            }
////            bulkRequest.get();
//        }
//    }
//}
