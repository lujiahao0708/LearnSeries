package com.lujiahao.concurrent.chapter01;

/**
 * 出号模拟程序
 * 三种方法均存在号码错乱情况,因为index相关的操作存在线程安全问题
 *
 * @author lujiahao
 * @date 2019-11-20
 */
public class TicketWindowTest {

    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
    }

    private static void demo1() {
        TicketWindow tw1 = new TicketWindow("1号出号机");
        tw1.start();

        TicketWindow tw2 = new TicketWindow("2号出号机");
        tw2.start();

        TicketWindow tw3 = new TicketWindow("3号出号机");
        tw3.start();

        TicketWindow tw4 = new TicketWindow("4号出号机");
        tw4.start();
    }

    private static void demo2() {
        TicketWindowOpt tw1 = new TicketWindowOpt("1号优化出号机");
        tw1.start();

        TicketWindowOpt tw2 = new TicketWindowOpt("2号优化出号机");
        tw2.start();

        TicketWindowOpt tw3 = new TicketWindowOpt("3号优化出号机");
        tw3.start();

        TicketWindowOpt tw4 = new TicketWindowOpt("4号优化出号机");
        tw4.start();
    }

    private static void demo3() {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread tw1 = new Thread(task, "1号出号机");
        Thread tw2 = new Thread(task, "2号出号机");
        Thread tw3 = new Thread(task, "3号出号机");
        Thread tw4 = new Thread(task, "4号出号机");

        tw1.start();
        tw2.start();
        tw3.start();
        tw4.start();
    }
}
