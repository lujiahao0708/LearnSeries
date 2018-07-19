package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue.impl.selltickets;

/**
 * 卖票者
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 15:49
 */
public class Consumer implements Runnable {
    private WindowQueue windowQueue;

    public Consumer(WindowQueue windowQueue) {
        this.windowQueue = windowQueue;
    }

    @Override
    public void run() {
        while (windowQueue.isAlive) {
            try {
                windowQueue.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
