package com.lujiahao.datastructure.BigDataStructure.linearlist;

/**
 * 线性表接口
 *
 * @author lujiahao
 * @date 2017/10/31
 */
public interface List<T> {
    /**
     * 将元素添加到线性表的末尾
     */
    public void add(T e);

    /**
     * 清除线性表
     */
    public void clear();

    /**
     * 获取i位置的元素
     */
    public T get(int i);

    /**
     * 返回列表中首次出现指定元素的索引,如果列表不包含此元素,则返回-1
     */
    public int indexOf(T e);

    /**
     * 在i后面插入一个元素e
     */
    public void insert(int i, T e);

    /**
     * 判断此线性表是否为空
     */
    public boolean isEmpty();

    /**
     * 返回列表中最后出现指定元素的索引,如果列表不包含此元素,则返回-1
     */
    public int lastIndexOf(T e);

    /**
     * 移除列表中指定位置的元素
     */
    public T remove(int i);

    /**
     * 用指定元素替换列表中指定位置的元素
     */
    public void set(int i, T e);

    /**
     * 返回线性表大小
     */
    public int size();
}
