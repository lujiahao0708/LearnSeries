package com.lujiahao.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * 尝试并行运行
 *
 * @author lujiahao
 * @date 2019-11-20
 */
public class TryConcurrencyThread {
    public static void main(String[] args) {
        // 通过匿名内部类的方式创建线程,并重写其中的run方法
        new Thread() {
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start();

        browseNews();
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }

    /**
     * 模拟等待并忽略异常
     *
     * @param seconds
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出结果:
     * Uh-huh, the good news.
     * Uh-huh, the nice music.
     * Uh-huh, the nice music.
     * Uh-huh, the good news.
     * Uh-huh, the nice music.
     * Uh-huh, the good news.
     * Uh-huh, the nice music.
     */
}
