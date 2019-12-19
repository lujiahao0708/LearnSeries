package com.lujiahao.controller;

import com.lujiahao.pojo.ApiRespDTO;
import com.lujiahao.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lujiahao
 * @date 2019/10/15
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // https://bbs.csdn.net/topics/392412090 登录成功后不会直接跳转的问题
    @PostMapping("/doLogin")
    @ResponseBody
    public ApiRespDTO login(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ApiRespDTO.buildSuccess();
        } catch (UnknownAccountException e) {
            return ApiRespDTO.buildError(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ApiRespDTO.buildError(e.getMessage());
        } catch (LockedAccountException e) {
            return ApiRespDTO.buildError(e.getMessage());
        } catch (AuthenticationException e) {
            return ApiRespDTO.buildError("认证失败！");
        }
    }

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

}