package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue;

import com.lujiahao.datastructure.BigDataStructure.queue.Queue;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-15 17:54
 */
public class Test {
    public static void main(String[] args) throws Exception {
        testCircleSequeueQueue1();
        testCircleSequeueQueue2();
        testCircleSequeueQueue3();
    }

    private static void testCircleSequeueQueue1() throws Exception{
        System.out.println("===================队列实现方式一===================");
        Queue queue = new CircleSequenceQueue1();
        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队头元素:" + queue.getFront());
        System.out.println("队尾元素:" + queue.getEnd());
        System.out.println("队列长度:" + queue.size());
        System.out.println("=========Queue start");
        while (!queue.isEmpty()) {
            System.out.print(queue.delete() + " ");
        }
        System.out.println();
        System.out.println("=========Queue end");

        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队列长度:" + queue.size());
        System.out.println("清空队列");
        queue.clean();
        System.out.println("队列长度:" + queue.size());
    }

    private static void testCircleSequeueQueue2() throws Exception{
        System.out.println("===================队列实现方式二===================");
        Queue queue = new CircleSequenceQueue2();
        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队头元素:" + queue.getFront());
        System.out.println("队尾元素:" + queue.getEnd());
        System.out.println("队列长度:" + queue.size());
        System.out.println("=========Queue start");
        while (!queue.isEmpty()) {
            System.out.print(queue.delete() + " ");
        }
        System.out.println();
        System.out.println("=========Queue end");

        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队列长度:" + queue.size());
        System.out.println("清空队列");
        queue.clean();
        System.out.println("队列长度:" + queue.size());
    }

    private static void testCircleSequeueQueue3() throws Exception{
        System.out.println("===================队列实现方式三===================");
        Queue queue = new CircleSequenceQueue3();
        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队头元素:" + queue.getFront());
        System.out.println("队尾元素:" + queue.getEnd());
        System.out.println("队列长度:" + queue.size());
        System.out.println("=========Queue start");
        while (!queue.isEmpty()) {
            System.out.print(queue.delete() + " ");
        }
        System.out.println();
        System.out.println("=========Queue end");

        queue.append(1);
        queue.append(2);
        queue.append(3);
        queue.append(4);
        queue.delete();
        queue.append(5);
        System.out.println("队列长度:" + queue.size());
        System.out.println("清空队列");
        queue.clean();
        System.out.println("队列长度:" + queue.size());
    }
}
