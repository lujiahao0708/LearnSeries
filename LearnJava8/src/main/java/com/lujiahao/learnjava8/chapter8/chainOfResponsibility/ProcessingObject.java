package com.lujiahao.learnjava8.chapter8.chainOfResponsibility;

/**
 * @author lujiahao
 * @date 2019-03-18 17:17
 */
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
