package com.lujiahao;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm实现
 *
 * @author lujiahao
 * @date 2019/10/14
 */
public class PermissionRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "permissionRealm";
    }

    /**
     * 用户权限和角色
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 当前用户登录信息
        String username = (String) principalCollection.getPrimaryPrincipal();

        // 模拟数据库查询用户角色和权限
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        roles.add("role1");
        permissions.add("user:read");

        // 增加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);

        return info;
    }


    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户信息
        String username = (String) token.getPrincipal();

        // 模拟从数据库获取用户名和密码
        String dbUsername = "lujiahao";
        String dbPassword = "123";
        // 验证用户
        if (!dbUsername.equals(username)) {
            return null;
        }
        // 参数列表依次是： 用户名  密码  当前realm名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, dbPassword, getName());
        return info;
    }
}
