package com.lujiahao;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author lujiahao
 * @date 2019/10/14
 */
public class TestRealm {

    /**
     * 封装登录方法
     */
    private Subject doLogin(String iniFileName, String username, String password) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:" + iniFileName);
        SecurityManager securityManager = factory.getInstance();
        // 3.将SecurityManger绑定到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 4.创建当前登录主体
        Subject currentUser = SecurityUtils.getSubject();
        // 5.绑定主体登录的身份凭证（即账户密码）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 6.主体登录
        try {
            currentUser.login(token);
            System.out.println("用户身份验证：" + currentUser.isAuthenticated());
        } catch (UnknownAccountException e) {
            System.out.println("账户信息错误：无此账户信息");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    @Test
    public void testRole() {
        // 用户登录，授权操作的前提是用户已经通过认证
        Subject subject = this.doLogin("shiro-roles.ini", "lujiahao", "123");

        System.out.println("验证用户是否拥有某个角色 true：拥有 false：没有");
        System.out.println(subject.hasRole("role1"));

        System.out.println("验证用户是否拥有所有角色 true：全部拥有 false：不全部拥有");
        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2", "role3")));

        System.out.println("验证用户是否拥有角色，返回boolean类型数组 true：拥有 false：没有");
        System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1", "role2", "role3"))));


        System.out.println("验证用户是否拥有某个角色 拥有：无异常 没有：报UnauthorizedException异常");
        subject.checkRole("role1");

        System.out.println("验证用户是否拥有所有角色 拥有：无异常 没有：报UnauthorizedException异常");
        subject.checkRoles("role1", "role2");

        System.out.println("验证用户是否拥有所有角色 拥有：无异常 没有：报UnauthorizedException异常");
        subject.checkRoles(Arrays.asList("role1", "role2"));
    }

    @Test
    public void testPermission() {
        // 用户登录，授权操作的前提是用户已经通过认证
        Subject subject = this.doLogin("shiro-roles.ini", "lujiahao", "123");


        System.out.println("验证用户是否拥有某个权限 true：拥有 false：没有");
        System.out.println(subject.isPermitted("user:list"));

        System.out.println("验证用户是否拥有所有权限 true：全部拥有 false：不全部拥有");
        System.out.println(subject.isPermittedAll("user:delete", "user:update", "user:create"));

        System.out.println("验证用户是否拥有权限，返回boolean类型数组 true：拥有 false：没有");
        System.out.println(Arrays.toString(subject.isPermitted("user:list", "user:update", "user:create")));


        System.out.println("验证用户是否拥有某个权限 拥有：无异常 没有：报UnauthorizedException异常");
        subject.checkPermission("user:update");

        System.out.println("验证用户是否拥有所有权限 拥有：无异常 没有：报UnauthorizedException异常");
        subject.checkPermissions("user:delete", "user:update", "user:create");

    }

    @Test
    public void testPermissionRealm() {
        // 用户登录，授权操作的前提是用户已经通过认证
        Subject subject = this.doLogin("shiro-permission-realm.ini", "lujiahao", "123");

        System.out.println(subject.isPermitted("user:read"));
        System.out.println(subject.hasRole("role1"));
    }
}