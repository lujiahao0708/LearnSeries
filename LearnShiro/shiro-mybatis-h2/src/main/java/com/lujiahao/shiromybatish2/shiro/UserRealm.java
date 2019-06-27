package com.lujiahao.shiromybatish2.shiro;

import com.lujiahao.shiromybatish2.domain.User;
import com.lujiahao.shiromybatish2.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lujiahao
 * @date 2019-06-26 21:52
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        // 给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 添加资源授权字符串
        //info.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        User dbUser = userService.findById(user.getId());
        info.addStringPermission(dbUser.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        UsernamePasswordToken utoken = (UsernamePasswordToken) token;

        User user = userService.findByName(utoken.getUsername());
        if (user == null) {
            // 用户名不存在
            // 直接返回null shiro底层会抛出UnknowAccountException
            return null;
        }


        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
