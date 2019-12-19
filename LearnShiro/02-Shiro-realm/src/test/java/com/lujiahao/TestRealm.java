package com.lujiahao;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author lujiahao
 * @date 2019/10/14
 */
public class TestRealm {

    /**
     * 测试自定义realm
     */
    @Test
    public void testCustomRealm() {
        // 1.加载配置文件，创建SecurityManger工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        // 2.获得SecurityManager实例对象
        SecurityManager securityManager = factory.getInstance();
        // 3.将SecurityManger绑定到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 4.创建当前登录主体
        Subject currentUser = SecurityUtils.getSubject();
        // 5.绑定主体登录的身份凭证（即账户密码）
        UsernamePasswordToken token = new UsernamePasswordToken("lujiahao222", "123");
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
        // 7.注销登录
        currentUser.logout();
        System.out.println("用户身份验证：" + currentUser.isAuthenticated());
    }

    /**
     * 测试自定义加密realm
     */
    @Test
    public void testCustomEncryRealm() {
        // 1.加载配置文件，创建SecurityManger工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-encry-realm.ini");
        // 2.获得SecurityManager实例对象
        SecurityManager securityManager = factory.getInstance();
        // 3.将SecurityManger绑定到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 4.创建当前登录主体
        Subject currentUser = SecurityUtils.getSubject();
        // 5.绑定主体登录的身份凭证（即账户密码）
        UsernamePasswordToken token = new UsernamePasswordToken("lujiahao", "123");
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
        // 7.注销登录
        currentUser.logout();
        System.out.println("用户身份验证：" + currentUser.isAuthenticated());
    }

    @Test
    public void genPassword() {
        String username = "lujiahao";
        String password = "123";
        Md5Hash md5Hash = new Md5Hash(password);
//        Md5Hash md5Hash = new Md5Hash(password, "lujiahao", 2);
        System.out.println(md5Hash);
    }
}
