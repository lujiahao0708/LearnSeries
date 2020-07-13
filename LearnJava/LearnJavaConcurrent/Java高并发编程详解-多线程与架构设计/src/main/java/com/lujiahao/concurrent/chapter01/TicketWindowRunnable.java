package com.lujiahao.concurrent.chapter01;

/**
 * 实现Runnable接口,重写run方法
 * @author lujiahao
 * @date 2019-11-20
 */
public class TicketWindowRunnable implements Runnable {

    // 最多受理50笔业务
    private static final int MAX = 50;

    // 不用static修饰
    private int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + " 的号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
