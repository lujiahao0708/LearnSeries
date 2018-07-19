package com.lujiahao.service;

import com.lujiahao.entity.User;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-07-09 上午11:57
 */
public interface UserService {

    public boolean insert(User u);

    public List<User> findAll();

    public List<User> findByUserIds(List<Integer> ids);

    public void transactionTestSucess();

    public void transactionTestFailure() throws IllegalAccessException;

}

