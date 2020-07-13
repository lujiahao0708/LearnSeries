package com.lujiahao.concurrent.chapter03;

import java.util.stream.IntStream;

/**
 *
 * @author lujiahao
 * @date 2019-11-23
 */
public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create)
                .forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            if (index == 0) {
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
