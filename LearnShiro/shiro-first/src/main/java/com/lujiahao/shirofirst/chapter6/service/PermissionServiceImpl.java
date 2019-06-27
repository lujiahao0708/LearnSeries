package com.lujiahao.shirofirst.chapter6.service;

import com.lujiahao.shirofirst.chapter6.dao.PermissionDao;
import com.lujiahao.shirofirst.chapter6.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2019-06-26 16:59
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
