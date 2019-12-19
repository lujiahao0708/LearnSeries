package com.lujiahao.controller;

import com.lujiahao.bean.AJAXResult;
import com.lujiahao.bean.Permission;
import com.lujiahao.bean.User;
import com.lujiahao.service.PermissionService;
import com.lujiahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author lujiahao
 * @date 2019-10-04 15:54
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/")
    public String index0() {
        return "redirect:main";
    }
    @RequestMapping("/index")
    public String index() {
        return "redirect:main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model) {
        User dbUser = userService.query4Login(user);
        if (dbUser != null) {
            return "main";
        } else {
            String errorMsg = "登录账号或密码不正确，请重新输入";
            model.addAttribute("errMsg", errorMsg);
            return "redirect:login";
        }
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session, HttpServletResponse response) {
        AJAXResult result = new AJAXResult();
        User dbUser = userService.query4Login(user);
        if ( dbUser != null ) {
            session.setAttribute("loginUser", dbUser);

            // 获取用户权限信息
            List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
            Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
            Permission root = null;
            Set<String> uriSet = new HashSet<String>();
            for ( Permission permission : permissions ) {
                permissionMap.put(permission.getId(), permission);
                if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
                    uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
                }
            }
            session.setAttribute("authUriSet", uriSet);
            for ( Permission permission : permissions ) {
                Permission child = permission;
                if ( child.getPid() == 0 ) {
                    root = permission;
                } else {
                    Permission parent = permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }
            session.setAttribute("rootPermission", root);

            // token放置到cookie，避免重复登录
//            Cookie cookie = new Cookie("token", dbUser.getToken());
//            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
//            response.addCookie(cookie);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @ResponseBody
    @RequestMapping("/doAJAXRegister")
    public Object doAJAXRegister(@RequestParam String account,
            @RequestParam String password,
            @RequestParam String email,
            HttpSession session, HttpServletResponse response) {
        AJAXResult result = new AJAXResult();
        try {
            User user = new User();
            user.setLoginacct(account);
            user.setUsername(account);
            user.setUserpswd(password);
            user.setToken(UUID.randomUUID().toString());
            user.setEmail(email);
            userService.insertUser(user);
            session.setAttribute("loginUser", user);

            // token放置到cookie，避免重复登录
            Cookie cookie = new Cookie("token", user.getToken());
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除单个
        //session.removeAttribute("loginUser");
        // 所有session过期
        session.invalidate();
        return "redirect:login";
    }

    // 这个不用添加  springboot自带了这个功能
//    @RequestMapping("/error")
//    public String error() {
//        return "error";
//    }

}
