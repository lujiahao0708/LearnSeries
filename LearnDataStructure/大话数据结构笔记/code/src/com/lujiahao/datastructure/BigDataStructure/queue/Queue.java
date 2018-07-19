package com.lujiahao.datastructure.BigDataStructure.queue;

/**
 * 队列接口
 * @author lujiahao
 * @date 2017/11/15
 */
public interface Queue {

    /**
     * 入队
     * @param object
     * @throws Exception
     */
    void append(Object object) throws Exception;

    /**
     * 出队
     * @return
     * @throws Exception
     */
    Object delete() throws Exception;

    /**
     * 获得队头元素
     * @return
     * @throws Exception
     */
    Object getFront() throws Exception;

    /**
     * 获得队尾元素
     * @return
     * @throws Exception
     */
    Object getEnd() throws Exception;

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断队列是否满
     * @return
     */
    boolean isFull();

    /**
     * 队列元素个数
     * @return
     */
    int size();

    /**
     * 清空队列
     * @throws Exception
     */
    void clean() throws Exception;
}
