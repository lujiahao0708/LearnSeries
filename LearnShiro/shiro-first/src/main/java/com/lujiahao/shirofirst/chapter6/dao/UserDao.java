package com.lujiahao.shirofirst.chapter6.dao;


import com.lujiahao.shirofirst.chapter6.entity.User;

import java.util.Set;

/**
 * @author lujiahao
 * @date 2019-06-26 17:15
 */
public interface UserDao {

    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
