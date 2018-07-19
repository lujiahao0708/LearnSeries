package com.lujiahao.datastructure.BigDataStructure.linearlist2;

/**
 * 线性表接口
 *
 * @author lujiahao
 * @date 2017/11/1
 */
public interface List {

    /**
     * 获得线性表长度
     * @return
     */
    public int size();

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 插入元素
     * @param index
     * @param obj
     * @throws Exception
     */
    public void insert(int index, Object obj) throws Exception;

    /**
     * 删除元素
     * @param index
     * @return
     * @throws Exception
     */
    public Object delete(int index) throws Exception;

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     * @throws Exception
     */
    public Object get(int index) throws Exception;
}
