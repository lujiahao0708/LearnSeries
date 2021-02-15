package com.lujiahao.javaconcurrency.chapter15;

/**
 *
 * @author lujiahao
 * @date 2020-09-04
 */
@FunctionalInterface
public interface Task<T> {

    /** 任务执行接口,允许有返回值 **/
    T call();
}
