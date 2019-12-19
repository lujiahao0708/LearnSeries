package com.lujiahao.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义realm实现
 *
 * @author lujiahao
 * @date 2019/10/14
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "myRealm";
    }

    /**
     * 用户权限和角色
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
