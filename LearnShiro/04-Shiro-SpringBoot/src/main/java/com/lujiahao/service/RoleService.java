package com.lujiahao.service;

import com.lujiahao.mapper.RoleMapper;
import com.lujiahao.mapper.UserRoleMapper;
import com.lujiahao.pojo.Role;
import com.lujiahao.pojo.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019/10/16
 */
@Slf4j
@Service
public class RoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRolesByUid(Integer uid) {
        List<UserRole> userRoleList = userRoleMapper.getUserRoleByUid(uid);
        List<Long> ridSet = userRoleList.stream().map(r -> r.getRid()).collect(Collectors.toList());
        List<Role> roleList = roleMapper.getRolesByIds(ridSet);
        return roleList;
    }
}
