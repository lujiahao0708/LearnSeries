package com.lujiahao.datastructure.BigDataStructure.linearlist2;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-02 11:21
 */
public class SequeueList implements List {

    /**
     * 数组默认大小
     */
    private int DEFAULT_SIZE = 5;

    /**
     * 存储数据的数组
     */
    private Object[] objArr;

    /**
     * 数组长度
     */
    private int capacity;

    /**
     * 数组中元素个数
     */
    private int size;

    public SequeueList() {
        init(DEFAULT_SIZE);
    }

    public SequeueList(int size) {
        init(size);
    }

    private void init(int size) {
        objArr = new Object[size];
        this.size = 0;
        this.capacity = size;
        System.out.println("初始化数组 长度:" + this.capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, Object obj) throws Exception {
        insert(index, obj);
    }

    /**
     * 扩展数组
     *
     * @param needCapacity 数组需要的空间大小
     */
    private void expandArray(int needCapacity) {
        if (needCapacity > capacity) {
            // 不断将数组扩容,直到满足
            while (needCapacity > capacity) {
                System.out.println("数组空间不足,申请扩容 当前容量:" + capacity);
                capacity <<= 1;
                System.out.println("数组扩容后容量:" + capacity);
            }
            // 复制元素
            Object[] newArr = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = objArr[i];
            }
            objArr = newArr;
        }
    }

    @Override
    public void insert(int index, Object obj) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引超出数组范围");
        }
        expandArray(size + 1);
        for (int i = size - 1; i >= index; i--) {
            objArr[i + 1] = objArr[i];
        }
        objArr[index] = obj;
        size++;
    }

    @Override
    public Object delete(int index) throws Exception {
        if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException("索引超出数组范围");
        }
        Object del = objArr[index];
        for (int i = index; i < size -1; i++) {
            objArr[i] = objArr[i+1];
        }
        size--;
        shirnkArray(size + 1);
        return del;
    }

    /**
     * 收缩数组
     *
     * @param needCapacity 数组
     */
    private void shirnkArray(int needCapacity) {
        if (needCapacity < capacity) {
            // 不断将数组扩容,直到满足
            while (needCapacity < capacity) {
                System.out.println("数组空间缩减 当前容量:" + capacity);
                capacity >>= 1;
                System.out.println("数组缩减后容量:" + capacity);
            }
            // 复制元素
            Object[] newArr = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = objArr[i];
            }
            objArr = newArr;
        }
    }

    @Override
    public Object get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引超出数组范围");
        }
        return objArr[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(objArr[i]).append(",");
        }
        String s = sb.replace(sb.length() - 1, sb.length(), "]").toString();
        return s;
    }
}

