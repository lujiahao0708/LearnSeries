package com.lujiahao.datastructure.BigDataStructure.linearlist;

/**
 * 单链表实现
 *
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-01 14:18
 */
public class LinkList<T> implements List<T> {

    /**
     * 保存头结点
     */
    private Node<T> header;
    /**
     * 保存尾节点
     */
    private Node<T> tail;
    /**
     * 保存已含有的节点数
     */
    private int size;

    /**
     * 创建空链表
     */
    public LinkList() {
        header = null;
        tail = null;
    }

    /**
     * 已指定数据元素创建链表,只有一个元素
     *
     * @param element
     */
    public LinkList(T element) {
        header = new Node<>(element, null);
        // 只有一个节点，header tail都指向该节点
        tail = header;
        size++;
    }

    /**
     * 在尾部插入
     */
    @Override
    public void add(T e) {
        // 如果链表是空的
        if (header == null) {
            header = new Node<>(e, null);
            // 只有一个节点,header和tail都指向这个
            tail = header;
        } else {
            // 创建新节点
            Node newNode = new Node(e, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        // 将header和tail置为null
        header = null;
        tail = null;
        size = 0;
    }

    /**
     * 获取指定索引处的元素
     */
    @Override
    public T get(int i) {
        return this.getNodeByIndex(i).getData();
    }

    @Override
    public int indexOf(Object e) {
        // 从header开始遍历
        Node currentNode = header;
        for (int i = 0; i < size && currentNode != null; i++, currentNode = currentNode.getNext()) {
            if (currentNode.getData().equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        // 如果是空链表
        if (header == null) {
            add(e);
        } else {
            // 当index=0是,即在链表头插入
            if (0 == i) {
                addAtHead(e);
            } else {
                // 获取前一个节点
                Node pre = getNodeByIndex(i - 1);
                // 让pre的next指向新节点,新节点的next指向原来pre的next节点
                pre.setNext(new Node(e, pre.getNext()));
                size++;
            }
        }
    }

    /**
     * 头部插入
     */
    public void addAtHead(T element) {
        // 创建新节点
        Node newNode = new Node(element, null);
        // 让新节点的next指向header
        newNode.setNext(header);
        // 以新节点作为新的header
        header = newNode;
        if (tail == null) {
            // 如果插入前是空表
            tail = header;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(Object e) {
        return 0;
    }

    @Override
    public T remove(int i) {
        return delete(i - 1);
    }

    /**
     * 删除指定索引处的元素
     */
    private T delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        Node del = null;
        // 如果删除的是头结点
        if (index == 0) {
            del = header;
            header = header.getNext();
        } else {
            // 获得要删除节点的前一个节点
            Node pre = getNodeByIndex(index - 1);
            // 获取要删除的节点
            del = pre.getNext();
            pre.setNext(del.getNext());
            // 将被删除节点的next引用置为空
            del.setNext(null);
        }
        size--;
        return (T) del.getData();
    }

    @Override
    public void set(int i, Object e) {

    }

    /**
     * 获取指定位置的节点
     */
    private Node<T> getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        // 从header开始遍历
        Node currentNode = header;
        for (int i = 0; i < size && currentNode != null; i++, currentNode = currentNode.getNext()) {
            if (i == index) {
                return currentNode;
            }
        }
        return null;
//        int j = 0;
//        while (currentNode != null && j < index) {
//            currentNode = currentNode.getNext();
//            ++j;
//        }
//        if (currentNode == null || j > index) {
//            return null;
//        }
//        return currentNode;
    }

    /**
     * 返回链表长度
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.getNext()) {
                sb.append(current.getData().toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }

    }
}
