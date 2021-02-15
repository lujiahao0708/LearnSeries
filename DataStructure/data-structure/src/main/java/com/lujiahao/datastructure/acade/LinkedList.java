package com.lujiahao.datastructure.acade;

/**
 * 链表接口
 * @author lujiahao
 * @date 2020-09-02
 */
public interface LinkedList<T> {
    /** 在链表头部添加，时间复杂度为O(1) **/
    void addFirst(T t);
    /** 在链表尾部添加需要从头遍历，时间复杂度为O(n) **/
    void addLast(T t);
    /** 在链表任意位置添加，平均情况下为O(n/2)=O(n) **/
    void add(int index, T t);
    /** 删除链表的第一个元素,时间复杂度为O(1) **/
    T removeFirst();
    /** 删除链表最后一个元素，需要遍历找到最后元素的前一个元素，故时间复杂度为O(n) **/
    T removeLast();
    /** 删除链表中任意位置节点,平均情况下时间复杂度为O(n/2)=O(n) **/
    T remove(int index);
    /** 链表不支持随机访问，需要从头开始寻找直到找到需要修改的节点，故时间复杂度为O(n) **/
    void set(int index, T t);
    /** 链表不支持随机访问，需要从头开始寻找直到找到需要的节点，故时间复杂度为O(n) **/
    T get(int index);
    /** 链表不支持随机访问，需要从头开始寻找直到找到需要的节点，故时间复杂度为O(n) **/
    boolean contains(T t);
    /** 遍历链表 **/
    void traverse();
    /** 链表判空 **/
    boolean isEmpty();
}
