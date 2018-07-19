package com.lujiahao.datastructure.BigDataStructure.queue.linkqueue.impl;

import com.lujiahao.datastructure.BigDataStructure.queue.linkqueue.Node;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 17:17
 */
public class LinkStack implements Stack {

    Node head;  //栈顶指针
    int size;  //结点的个数

    public LinkStack() {
        head = null;
        size = 0;
    }

    @Override
    public Object getTop() throws Exception {
        // TODO Auto-generated method stub
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return head == null;
    }

    @Override
    public Object pop() throws Exception {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new Exception("栈为空！");
        }
        Object obj = head.getElement();
        head = head.getNext();
        size--;
        return obj;

    }

    @Override
    public void push(Object obj) throws Exception {
        // TODO Auto-generated method stub
        head = new Node(obj, head);
        size++;
    }

}