package com.lujiahao.shirofirst.chapter6.dao;


import com.lujiahao.shirofirst.chapter6.entity.Role;

/**
 * @author lujiahao
 * @date 2019-06-26 17:12
 */
public interface RoleDao {

    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}

