package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue.impl.selltickets;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 15:51
 */
public class Test {
    public static void main(String[] args) {
        WindowQueue queue = new WindowQueue(2,2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);

        // 开始排队买票
        pThread.start();
        // 开始卖票
        cThread.start();
    }
}
