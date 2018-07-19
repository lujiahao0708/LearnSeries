package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue.impl.selltickets;

import com.lujiahao.datastructure.BigDataStructure.queue.Queue;
import com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue.CircleSequenceQueue3;

/**
 * 卖票窗口
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 15:35
 */
public class WindowQueue {
    /**
     * 卖票队列的默认大小
     */
    private int defaultQueueSize = 10;
    private int defaultTicketCount = 100;
    /**
     * 统计卖票的数量,一天最多卖张票
     */
    int num = 0;
    /**
     * 判断是否能继续卖票
     */
    boolean isAlive = true;

    private int queueSize;
    /**
     * 票总数
     */
    private int ticketCount = 100;

    private Queue queue;

    public WindowQueue() {
        init(defaultQueueSize, defaultTicketCount);
    }

    public WindowQueue(int queueSize) {
        init(queueSize, defaultTicketCount);
    }

    public WindowQueue(int queueSize, int ticketCount) {
        init(queueSize, ticketCount);
    }

    private void init(int queueSize, int ticketCount) {
        this.defaultQueueSize = queueSize;
        this.defaultTicketCount = ticketCount;
        queue = new CircleSequenceQueue3(defaultQueueSize);
    }

    /**
     * 排队买票
     */
    public synchronized void producer() throws Exception {
        if (queue.size() < defaultQueueSize) {
            // 等待买票的数量加1
            queue.append(num++);
            System.out.println("第" + num + "个客户排队等候买票!");
            // 唤醒卖票线程
            this.notifyAll();
        } else {
            try {
                System.out.println("队列已满...请等待!");
                // 队列满时,排队买票线程等待
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 卖票
     */
    public synchronized void consumer() throws Exception {
        if (queue.size() > 0) {
            Object object = queue.delete();
            int temp = Integer.parseInt(object.toString());
            System.out.println("第" + (temp + 1) + "个客户买到票离开队列!");
            // 如果当前队列为空,并且卖出的票数量大于等于100,说明卖票结束
            if (queue.isEmpty() && this.num >= this.defaultTicketCount) {
                this.isAlive = false;
                System.out.println("票已售空!");
            }
            // 唤醒排队买票线程
            this.notifyAll();
        } else {
            try {
                System.out.println("队列已空...请等待!");
                // 队列空时,卖票线程等待
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
