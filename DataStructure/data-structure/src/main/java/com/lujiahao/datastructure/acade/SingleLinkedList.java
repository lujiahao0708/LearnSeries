package com.lujiahao.datastructure.acade;

/**
 * 单链表实现
 * @author lujiahao
 * @date 2020-09-02
 */
public class SingleLinkedList<T> implements LinkedList<T> {

    /**
     * 头结点
     **/
    private Node head;
    /**
     * 链表长度
     **/
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T t) {
        // 1.初始化一个新结点
        Node cur = new Node(t);
        if (isEmpty()) {
            // 3.将 cur 指定为 head(链表为空,直接将当前节点作为头结点)
            head = cur;
        } else {
            // 2.将新结点链接到我们的原始头结点 head
            head.setNext(cur);
            // 3.将 cur 指定为 head
            head = cur;
        }
        this.size++;
    }

    @Override
    public void addLast(T t) {
        this.add(this.size - 1, t);
    }

    @Override
    public void add(int index, T t) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("index is error");
        }
        if (index == 0) {
            this.addFirst(t);
            return;
        }
        // 1.使用给定值初始化新结点 cur
        Node cur = new Node(t);
        // 2.查找到指定 index 位置的节点
        Node prev = this.head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.getNext();
        }
        // 3.将 cur 的 next 字段链接到 prev 的下一个结点 next
        cur.setNext(prev.getNext());
        // 4.将 prev 中的 next 字段链接到 cur
        prev.setNext(cur);
        this.size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("链表中已无元素");
        }

        Node del = this.head;
        this.head = this.head.getNext();
        del.setNext(null);
        this.size--;
        return (T) del.getT();
    }

    @Override
    public T removeLast() {
        return this.remove(this.size - 1);
    }

    @Override
    public T remove(int index) {
        if (isEmpty()) {
            throw new IllegalArgumentException("链表中已无元素");
        }

        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("删除位置不合法");
        }

        // 链表中只有一个节点,直接使用移除第一个节点的逻辑即可
        if (this.size == 1) {
            return this.removeFirst();
        }

        int pos = 0;
        Node prev = this.head;
        while (prev != null) {
            // 找到要删除的节点上一个节点
            if (pos == index - 1) {
                // 要删除的节点
                Node del = prev.getNext();
                // 链接 prev 到 cur 的下一个节点 next
                prev.setNext(del.getNext());
                del.setNext(null);
                this.size--;
                return (T) del.getT();
            }
            pos++;
            prev = prev.getNext();
        }
        return null;
    }

    @Override
    public void set(int index, T t) {
        int pos = 0;
        Node node = this.head;
        while (node != null) {
            if (pos == index) {
                node.setT(t);
                break;
            }
            pos++;
            node = node.getNext();
        }
    }

    @Override
    public T get(int index) {
        int pos = 0;
        Node node = this.head;
        while (node != null) {
            if (pos == index) {
                return (T) node.getT();
            }
            pos++;
            node = node.getNext();
        }
        return null;
    }

    @Override
    public boolean contains(T t) {
        Node node = this.head;
        while (node != null) {
            if (node.getT().equals(t)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void traverse() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = this.head;
        while (node != null) {
            sb.append(node.getT().toString()).append(",");
            node = node.getNext();
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst(1);
//        singleLinkedList.addLast(2);
//        singleLinkedList.add(2, 3);
        singleLinkedList.traverse();

//        Integer removeFirst = singleLinkedList.removeFirst();
//        System.out.println("removeFirst:" + removeFirst);
//        Integer removeLast = singleLinkedList.removeLast();
//        System.out.println("removeLast:" + removeLast);
//        singleLinkedList.traverse();
        System.out.println(singleLinkedList.get(0));
        singleLinkedList.set(0, 2);
        System.out.println(singleLinkedList.get(0));
        System.out.println(singleLinkedList.contains(1));
    }
}

/**
 * 参考资料
 * https://leetcode-cn.com/leetbook/read/linked-list/jqjdj/   总结的话可以用这里的图
 * https://blog.csdn.net/weixin_36605200/article/details/88804537
 * https://www.cnblogs.com/tangxlblog/p/9947574.html
 * https://www.zaomianbao.com/blog/2020/03/18/25
 */
