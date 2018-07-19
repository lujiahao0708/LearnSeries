package com.lujiahao.springbootthymeleaf.controller;

/**
 * @author lujiahao
 * @date 2018-01-14 下午6:27
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller

public class TemplateController {
    /**
     * 返回html模板.
     */

    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String, Object> map) {

        map.put("hello", "from TemplateController.helloHtml");
        return "/helloHtml";
    }
}