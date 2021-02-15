//package com.lujiahao.queue;
//
//import com.lujiahao.lifecycle.AbstractLifeCycle;
//import com.lujiahao.service.queue.QueueInterface;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author lujiahao
// * @date 2018/11/1
// */
//@Component
//public class QueueClient extends AbstractLifeCycle{
//
//    protected Logger LOGGER = LoggerFactory.getLogger(getClass());
//
//    private static volatile boolean running = false;
//    private Thread thread = null;
//    protected Thread.UncaughtExceptionHandler handler = (t, e) -> LOGGER.error("parse events has an error", e);
//
//    @Resource(name = "blockingQueueService")
//    private QueueInterface queueInterface;
//
//    @Override
//    public void start() {
//        thread = new Thread(() -> queueInterface.pop(running));
//        thread.setUncaughtExceptionHandler(handler);
//        thread.start();
//        running = true;
//    }
//
//    @Override
//    public boolean isStart() {
//        return running;
//    }
//
//    @Override
//    public void shutdown() {
//        if (!running) {
//            return;
//        }
//
//        running = false;
//        if (thread != null) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//
//}
