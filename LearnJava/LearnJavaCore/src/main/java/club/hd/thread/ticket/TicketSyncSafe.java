package com.lujiahao.thread.ticket;

/**
 * 使用synchronized关键字实现同步
 * @author lujiahao
 * @date 2019/11/10
 */
class TicketSyncSafe {
    private int number = 30;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第:" + (number--) + "\t还剩:" + number);
        }
    }
}
