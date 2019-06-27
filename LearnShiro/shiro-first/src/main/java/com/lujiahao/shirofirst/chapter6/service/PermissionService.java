package com.lujiahao.learnshiro.chapter6.service;

import com.lujiahao.learnshiro.chapter6.entity.Permission;

/**
 * @author lujiahao
 * @date 2019-06-26 16:41
 */
public interface PermissionService {
    // 创建权限
    Permission createPermission(Permission permission);
    // 删除权限
    void deletePermission(Long permissionId);
}
