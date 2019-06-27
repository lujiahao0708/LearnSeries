package com.lujiahao.shiromybatish2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lujiahao
 * @date 2019-06-26 22:18
 */
@Controller
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String name, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);
            return "redirect:index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
        }

        return "login";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "noAuth";
    }
}
