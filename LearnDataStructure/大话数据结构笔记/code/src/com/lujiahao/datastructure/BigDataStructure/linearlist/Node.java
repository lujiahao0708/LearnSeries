package com.lujiahao.datastructure.BigDataStructure.linearlist;

/**
 * 链表节点
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-01 11:06
 */
public class Node<T> {
    /**
     * 保存数据
     */
    private T data;
    /**
     * 指向下个节点的引用
     */
    private Node<T> next;

    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
