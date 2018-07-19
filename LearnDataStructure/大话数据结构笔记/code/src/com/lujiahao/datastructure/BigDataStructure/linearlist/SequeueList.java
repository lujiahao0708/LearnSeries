package com.lujiahao.datastructure.BigDataStructure.linearlist;

import java.util.Arrays;

/**
 * 顺序表实现
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-10-31 14:05
 */
public class SequeueList<T> implements List {

    /**
     * 默认大小
     */
    private final int DEFAULT_SIZE = 16;

    /**
     * 保存数组的长度
     */
    private int capacity;

    /**
     * 定义一个数组,用于保存顺序线性表
     */
    private Object[] elementData;

    /**
     * 保存顺序线性表中当前元素的个数
     */
    private int size;

    /**
     * 以默认长度创建空的线性表
     */
    public SequeueList() {
        init(DEFAULT_SIZE);
    }

    public SequeueList(int size){
        init(size);
    }

    private void init(int initSize){
        capacity = initSize;
        elementData = new Object[capacity];
        this.size = 0;
    }

    @Override
    public void add(Object e) {
        insert(size,e);
    }

    @Override
    public void clear() {
        // 将所有元素置为null
        Arrays.fill(elementData, null);
        size = 0;
    }

    /**
     * 获取索引i的元素
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        return (T) elementData[i];
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }

        ensureCapacity(size + 1);

        // 将指定索引出之后的所有元素往后移
        System.arraycopy(elementData, i, elementData, i + 1, size - i);
        elementData[i] = e;
        size++;
    }

    private void ensureCapacity(int minCapacity) {
        // 如果数组的原有长度小于目前所需的长度
        if (minCapacity > capacity) {
            // 不断的将capacity*2,直到capacity大于minCapacity
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    /**
     * 删除指定索引处的元素
     */
    private T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        T oldValue = (T) elementData[index];
        // 需要移动的元素个数
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(Object e) {
        return indexOf(e);
    }

    @Override
    public T remove(int i) {
        return delete(i);
    }

    @Override
    public void set(int i, Object e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        elementData[i] = e;
    }

    /**
     * 获取线性表大小
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }
}
