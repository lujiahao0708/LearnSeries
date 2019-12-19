package com.lujiahao.realm;

import com.lujiahao.mapper.UserMapper;
import com.lujiahao.mapper.UserRoleMapper;
import com.lujiahao.pojo.Permission;
import com.lujiahao.pojo.Role;
import com.lujiahao.pojo.User;
import com.lujiahao.pojo.UserRole;
import com.lujiahao.service.PermissionService;
import com.lujiahao.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户自定义realm
 *
 * @author lujiahao
 * @date 2019/10/15
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        log.info("用户:{} 执行权限获取", username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取用户角色
        List<Role> roleList = roleService.getRolesByUid(user.getId());
        info.setRoles(roleList.stream().map(r -> r.getName()).collect(Collectors.toSet()));

        // 获取用户权限
        List<Permission> permissionList = permissionService.getPermissionsByRids(roleList.stream().map(r -> r.getId()).collect(Collectors.toList()));
        info.setStringPermissions(permissionList.stream().map(r -> r.getName()).collect(Collectors.toSet()));

        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        log.info("用户:{} 执行登录认证操作", userName);

        // 通过用户名到数据库查询用户信息
        User user = userMapper.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}