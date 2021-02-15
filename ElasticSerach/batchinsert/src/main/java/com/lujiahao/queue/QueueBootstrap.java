//package com.lujiahao.queue;
//
//import com.lujiahao.mq.OrderBO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.LinkedBlockingQueue;
//
///**
// * @author lujiahao
// * @date 2018-11-01 10:06
// */
//@Component
//public class QueueBootstrap {
//    private static final Logger LOGGER = LoggerFactory.getLogger(QueueBootstrap.class);
//
//    @Autowired
//    private QueueConsumer queueConsumer;
////    private BlockingQueue queue;
////
////    public QueueBootstrap() {
////        this.queue = new LinkedBlockingQueue();
////    }
//
//    public void addData(OrderBO order){
//        try {
//            BlockingQueue queue = queueConsumer.getQueue();
//            if (queue != null) {
//                queue.put(order);
//                LOGGER.info("存入数据:{}", order.getOrderNo());
//            } else {
//                LOGGER.info("queue is null");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addData(String order){
//        try {
//            BlockingQueue queue = queueConsumer.getQueue();
//            if (queue != null) {
//                queue.put(order);
//                LOGGER.info("存入数据");
//            } else {
//                LOGGER.info("queue is null");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
////    @PostConstruct
////    public void comsum() {
////        LogsConsumer consumer = new LogsConsumer(queue);
////        ExecutorService service = Executors.newCachedThreadPool();
////        service.execute(consumer);
////    }
//}
