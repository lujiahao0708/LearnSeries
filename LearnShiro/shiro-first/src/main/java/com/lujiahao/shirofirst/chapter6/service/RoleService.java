package com.lujiahao.learnshiro.chapter6.service;


import com.lujiahao.learnshiro.chapter6.entity.Role;

/**
 * @author lujiahao
 * @date 2019-06-26 16:43
 */
public interface RoleService {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    // 添加角色-权限之间关系
    void correlationPermissions(Long roleId, Long... permissionIds);

    // 移除角色-权限之间关系
    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
