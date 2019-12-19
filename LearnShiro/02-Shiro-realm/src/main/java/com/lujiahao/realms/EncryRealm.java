package com.lujiahao.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 加密
 * @author lujiahao
 * @date 2019/10/14
 */
public class EncryRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "encryRealm";
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
        // 模拟db中的密码：密码+盐+散列次数
        String dbPassword = "6b74111749b5409fa32e05b02816b760";
        // 验证用户
        if (!dbUsername.equals(username)) {
            return null;
        }

        // 参数列表依次是： 用户名  密码  盐  当前realm名字
        // 这里传入的密码一定是经过md5的，不然会报异常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, dbPassword, ByteSource.Util.bytes(username), getName());
        return info;
    }
}
