package com.lujiahao.thread.ticket;

/**
 * 线程不安全实现
 * @author lujiahao
 * @date 2019/11/10
 */
class TicketUnSafe {
    private int number = 30;

    public void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第:" + (number--) + "\t还剩:" + number);
        }
    }
}
