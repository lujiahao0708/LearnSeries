package com.lujiahao.service;

import com.lujiahao.bean.Role;
import com.lujiahao.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2019-10-05 17:04
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public List<Role> pageQueryData(Map<String, Object> map) {
        return roleDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return roleDao.pageQueryCount(map);
    }

    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    public void insertRolePermission(Map<String, Object> paramMap) {
        roleDao.deleteRolePermissions(paramMap);
        roleDao.insertRolePermission(paramMap);
    }

    public void insertRole(Role role) {
        roleDao.insertRole(role);
    }

}