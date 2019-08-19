package com.lujiahao.java8inaction.chapter2;

/**
 * 用 Runnable 执行代码块
 * @author lujiahao
 * @date 2019-03-02 18:42
 */
public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Java 8!");
            }
        });
        t.start();

        Thread t1 = new Thread(() -> System.out.println("Hello Lambda!"));
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
