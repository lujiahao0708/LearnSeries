package com.lujiahao.designpatterns.observer;

/**
 * 观察者接口
 * @author lujiahao
 * @date 2020-09-04
 */
@FunctionalInterface
public interface Observer {

    /** 更新方法 **/
    void update();
}
