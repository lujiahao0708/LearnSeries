package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue.impl.selltickets;

/**
 * 买票者
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 15:48
 */
public class Producer implements Runnable {
    private WindowQueue windowQueue;

    public Producer(WindowQueue windowQueue) {
        this.windowQueue = windowQueue;
    }

    @Override
    public void run() {
        while (windowQueue.num < 100) {
            try {
                windowQueue.producer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
