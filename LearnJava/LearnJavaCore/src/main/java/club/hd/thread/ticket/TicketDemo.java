//package com.lujiahao.thread.ticket;
//
///**
// * 买票程序
// * 多线程的原理是: 线程 操作 资源类
// * @author lujiahao
// * @date 2019/11/10
// */
//public class TicketDemo {
//    public static void main(String[] args) {
////        ticketUnsafe();
////        ticketSycnsafe();
//        ticketReentrantLocksafe();
//    }
//
//    public static void ticketUnsafe() {
//        TicketUnSafe t = new TicketUnSafe();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员1").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员2").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员3").start();
//    }
//
//    public static void ticketSycnsafe() {
//        TicketSyncSafe t = new TicketSyncSafe();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员1").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员2").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员3").start();
//    }
//
//    public static void ticketReentrantLocksafe() {
//        TicketReentrantLockSafe t = new TicketReentrantLockSafe();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员1").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员2").start();
//        new Thread(() -> { for (int i = 0; i < 40; i++) {t.sale();}}, "售票员3").start();
//    }
//}
//
