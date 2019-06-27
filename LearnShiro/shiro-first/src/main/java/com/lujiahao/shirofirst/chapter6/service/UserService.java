package com.lujiahao.shirofirst.chapter6.service;


import com.lujiahao.shirofirst.chapter6.entity.User;

import java.util.Set;

/**
 * @author lujiahao
 * @date 2019-06-26 16:49
 */
public interface UserService {
    User createUser(User user);

    void changePassword(Long userId, String newPassword);

    // 添加用户-角色关系
    void correlationRoles(Long userId, Long... roleIds);

    // 移除用户-角色关系
    void uncorrelationRoles(Long userId, Long... roleIds);

    // 根据用户名查找用户
    User findByUsername(String username);

    // 根据用户名查找其角色
    Set<String> findRoles(String username);

    // 根据用户名查找其权限
    Set<String> findPermissions(String username);
}
