package com.lujiahao.datastructure.BigDataStructure.queue.linkqueue;

import com.lujiahao.datastructure.BigDataStructure.queue.Queue;

/**
 * 链式队列
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 16:49
 */
public class LinkQueue implements Queue {
    /**
     * 队头
     */
    private Node front;
    /**
     * 队尾
     */
    private Node rear;
    /**
     * 计数器
     */
    private int count;

    public LinkQueue() {
        init();
    }

    private void init() {
        front = rear = null;
        count = 0;
    }

    @Override
    public void append(Object object) throws Exception {
        Node node = new Node(object, null);
        // 如果当前队列不为空
        if (rear != null) {
            // 队尾节点指向新节点
            rear.next = node;
        }
        // 设置队尾节点为新节点
        rear = node;

        // 要插入的结点是第一个结点
        if (front == null) {
            front = node;
        }
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已空!");
        }
        Node node = front;
        front = front.next;
        count--;
        return node.getElement();
    }

    @Override
    public Object getFront() throws Exception {
        if (!isEmpty()) {
            return front.getElement();
        } else {
            return null;
        }
    }

    @Override
    public Object getEnd() throws Exception {
        if (!isEmpty()) {
            return rear.getElement();
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
        // 链式队列
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
