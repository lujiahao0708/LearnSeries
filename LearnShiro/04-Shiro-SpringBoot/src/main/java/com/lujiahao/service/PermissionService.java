package com.lujiahao.service;

import com.lujiahao.mapper.PermissionMapper;
import com.lujiahao.mapper.RolePermissionMapper;
import com.lujiahao.pojo.Permission;
import com.lujiahao.pojo.RolePermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019/10/16
 */
@Slf4j
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public List<Permission> getPermissionsByRid(Integer rid) {
        List<RolePermission> rolePermissionList = rolePermissionMapper.getRolePermissionByRid(rid);
        List<Long> pidSet = rolePermissionList.stream().map(r -> r.getPid()).collect(Collectors.toList());
        List<Permission> permissionList = permissionMapper.getPermissionsByIds(pidSet);
        return permissionList;
    }

    public List<Permission> getPermissionsByRids(List<Integer> ridList) {
        List<RolePermission> rolePermissionList = rolePermissionMapper.getRolePermissionByRids(ridList);
        List<Long> pidSet = rolePermissionList.stream().map(r -> r.getPid()).collect(Collectors.toList());
        List<Permission> permissionList = permissionMapper.getPermissionsByIds(pidSet);
        return permissionList;
    }
}
