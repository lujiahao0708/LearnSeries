package com.lujiahao.datastructure.acade;

import java.util.Objects;

public class Node<T> {
    private T t;
    private Node next;

    public Node(T t, Node next) {
        this.t = t;
        this.next = next;
    }

    public Node(T t) {
        this(t, null);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /** 重写 equals 和 hashcode 方法,方便后面比较 **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return t.equals(node.t) &&
                next.equals(node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, next);
    }
}
