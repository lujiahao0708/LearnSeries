package com.lujiahao.datastructure.BigDataStructure.queue.circlesequeue;

import com.lujiahao.datastructure.BigDataStructure.queue.Queue;

/**
 * 循环顺序队列
 * 办法2：保留一个元素的存储空间。此时，队列满时的判断条件为  (rear + 1) % maxSize == front；队列空的判断条件还是front == rear。
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 14:31
 */
public class CircleSequenceQueue2 implements Queue {
    /**
     * 默认大小
     */
    private static final int defaultSize = 10;
    /**
     * 队头
     */
    private int front;
    /**
     * 队尾
     */
    private int rear;
    /**
     * 队列最大大小
     */
    private int maxSize;
    /**
     * 队列中元素个数
     */
    private int queueSize;
    /**
     * 队列
     */
    private Object[] objects;

    public CircleSequenceQueue2() {
        init(defaultSize);
    }

    public CircleSequenceQueue2(int size) {
        init(size);
    }

    private void init(int size) {
        front = rear = queueSize = 0;
        maxSize = size;
        objects = new Object[size];
    }

    @Override
    public void append(Object object) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满!");
        }
        objects[rear] = object;
        rear = (rear + 1) % maxSize;
        queueSize++;
    }

    @Override
    public Object delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列空!");
        }
        Object object = objects[front];
        front = (front + 1) % maxSize;
        queueSize--;
        return object;
    }

    @Override
    public Object getFront() throws Exception {
        if (!isEmpty()) {
            return objects[front];
        }
        return null;
    }

    @Override
    public Object getEnd() throws Exception {
        if (!isEmpty()) {
            return objects[rear - 1];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public void clean() throws Exception {
        while (!isEmpty()) {
            delete();
        }
    }
}
