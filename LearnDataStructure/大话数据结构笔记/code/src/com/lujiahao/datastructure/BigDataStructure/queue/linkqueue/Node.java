package com.lujiahao.datastructure.BigDataStructure.queue.linkqueue;

/**
 * 结点类
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 16:42
 */
public class Node {
    /**
     * 数据域
     */
    Object element;
    /**
     * 指针域
     */
    Node next;

    /**
     * 头结点的构造方法
     * @param nextval
     */
    public Node(Node nextval){
        this.next = nextval;
    }

    /**
     * 非头结点的构造方法
     * @param object
     * @param nextval
     */
    public Node(Object object, Node nextval){
        this.element = object;
        this.next = nextval;
    }

    /**
     * 获得当前节点的后继结点
     * @return
     */
    public Node getNext(){
        return this.next;
    }

    /**
     * 获得当前的数据域的值
     * @return
     */
    public Object getElement(){
        return this.element;
    }

    /**
     * 设置当前节点的指针域
     * @param nextval
     */
    public void setNext(Node nextval){
        this.next = nextval;
    }

    /**
     * 设置当前节点的数据域
     * @param object
     */
    public void setElement(Object object){
        this.element = object;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
