package com.lujiahao.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lujiahao
 * @date 2019-06-26 21:45
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String test(Model model) {
        model.addAttribute("name", "lujiahao");
        return "index";
    }
}
