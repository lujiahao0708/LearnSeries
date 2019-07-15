package com.lujiahao.linear_table.sequence;

import java.util.Arrays;

/**
 * @author lujiahao
 * @date 2019-07-15 18:14
 */
public class SequenceList<T> {
    // 默认长度
    private final int DEFAULT_SIZE = 16;

    // 保存数组的长度
    private int capacity;

    // 数组,保存顺序线性表
    private Object[] elementData;

    // 顺序线性表中当前元素个数
    private int size = 0;

    // 默认长度创建空线性表
    public SequenceList() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 以一个初始化元素创建顺序线性表
    public SequenceList(T element) {
        this();
        elementData[0] = element;
        size++;
    }

    // 以指定长度创建顺序线性表
    public SequenceList(T element, int initSize) {
        capacity = 1;
        // 把capacity设置为大于initSize的最小的2的n次方
        while (capacity < initSize) {
            capacity <<= 1;
        }

        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    // 获取线性表的大小
    public int length() {
        return size;
    }

    // 获取索引i的元素
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        return (T) elementData[i];
    }

    // 根据元素查找在线性表中的位置
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // 向顺序表中指定位置插入元素
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        ensureCapacity(size + 1);

        // 将指定索引处之后的所有元素后移
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }
    private void ensureCapacity(int minCapacity) {
        // 如果数组的原有长度小于目前所需的长度
        if (minCapacity > capacity) {
            // 不断的将capacity*2,知道capacity大于minCapacity
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData, capacity);

        }
    }

    // 在线性表的末端增加一个元素
    public void add(T element) {
        insert(element, size);
    }

    // 删除指定索引处的元素
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("索引超过线性表范围");
        }
        T oldValue = (T) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;
        return oldValue;
    }

    // 删除最后一个元素
    public T remove() {
        return delete(size - 1);
    }

    // 判断线性表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空线性表
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    public String toString(){
        if(size == 0){
            return "[]";
        }
        else{
            StringBuilder sb = new StringBuilder("[");

            for(int i=0;i<size;i++){
                sb.append(elementData[i].toString() + ", ");
            }

            int len = sb.length();

            return sb.delete(len-2, len).append("]").toString();
        }
    }

}
