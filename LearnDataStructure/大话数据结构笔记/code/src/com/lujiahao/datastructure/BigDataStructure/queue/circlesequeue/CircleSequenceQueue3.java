package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue;

import com.lujiahao.datastructure.BigDataStructure.queue.Queue;

/**
 * 循环顺序队列
 * 办法3：设计一个计数器count，统计队列中的元素个数。
 * 此时，队列满的判断条件为：count > 0 && rear == front ；队列空的判断条件为count == 0。
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-15 17:43
 */
public class CircleSequenceQueue3 implements Queue {

    // 默认队列长度
    public static final int defaultSize = 10;
    // 队头
    private int front;
    // 队尾
    private int rear;
    // 统计元素个数的计数器
    private int count;
    // 队列的最大长度
    private int maxSize;
    // 队列
    Object[] queue;

    public CircleSequenceQueue3() {
        init(defaultSize);
    }

    public CircleSequenceQueue3(int size) {
        init(size);
    }

    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Object[size];
    }

    @Override
    public void append(Object object) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满!");
        }
        queue[rear] = object;
        rear = (rear + 1) % maxSize;
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空!");
        }
        Object obj = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return obj;
    }

    @Override
    public Object getFront() throws Exception {
        if (!isEmpty()) {
            return queue[front];
        } else {
            return null;
        }
    }

    @Override
    public Object getEnd() throws Exception {
        if (!isEmpty()) {
            return queue[rear - 1];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return 0 == count;
    }

    @Override
    public boolean isFull() {
        if (count > 0 && front == rear) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clean() throws Exception {
        while (!isEmpty()) {
            delete();
        }
    }
}
