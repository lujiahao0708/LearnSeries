package com.lujiahao.concurrent.chapter01;

/**
 * 继承Thread类,重写run方法
 * @author lujiahao
 * @date 2019-11-20
 */
public class TicketWindow extends Thread {
    // 柜台名称
    private final String name;

    // 最多受理50笔业务
    private static final int MAX = 50;

    private int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台:" + name + " 当前的号码是:" + (index++));
        }
    }
}
