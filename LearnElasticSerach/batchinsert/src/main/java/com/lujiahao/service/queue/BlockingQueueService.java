//package com.lujiahao.service.queue;
//
//import com.google.common.collect.Queues;
//import com.lujiahao.service.ESService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.TimeUnit;
//
///**
// * BlockingQueue实现队列
// * @author lujiahao
// * @date 2018-11-06 15:59
// */
//@Service
//public class BlockingQueueService extends AbsQueueService implements QueueInterface{
//    private BlockingQueue queue;
//    private volatile int count = 0;
//
//    @Autowired
//    private ESService esService;
//
//    @PostConstruct
//    public void init() {
//        if (queue == null) {
//            queue = new ArrayBlockingQueue(1000);
//        }
//    }
//
//    @Override
//    public void push(String msgId, Object object) {
//        try {
//            if (queue != null) {
//                queue.put(object);
//                LOGGER.info("[BlockingQueue实现队列][存入数据][queue.size={}]", queue.size());
//            } else {
//                LOGGER.info("[BlockingQueue实现队列][queue is null]");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean handleMessage() {
//        return pop();
//    }
//
//    @Override
//    public boolean pop() {
//        while (running) {
//            ++count;
//            int saveSize = 0;
//            List<Object> dataList = new ArrayList<>();
//            try {
//                LOGGER.info("[BlockingQueue实现队列][task start running]");
//                Queues.drain(queue, dataList, 1000, 200, TimeUnit.MILLISECONDS);
//                saveSize =  esService.batchInsertData(dataList);
//            }catch (Exception e){
//                LOGGER.error("[BlockingQueue实现队列][drain queues error]", e);
//            } finally {
//                LOGGER.info("[BlockingQueue实现队列][执行次数:{},队列长度:{},保存个数:{}", count, dataList.size(), saveSize);
//                saveSize = 0;
//                dataList = null;
//            }
//        }
//        return true;
//    }
//}
