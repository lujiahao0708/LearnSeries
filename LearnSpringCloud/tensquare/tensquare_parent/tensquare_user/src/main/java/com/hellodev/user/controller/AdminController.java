package com.hellodev.user.controller;

import java.util.HashMap;
import java.util.Map;

import com.hellodev.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hellodev.user.pojo.Admin;
import com.hellodev.user.service.AdminService;

import com.hellodev.common.entity.PageResult;
import com.hellodev.common.entity.Result;
import com.hellodev.common.entity.StatusCode;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理员
 *
 * @author lujiahao
 * @date 2019-09-08
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 用户登陆
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String loginName, String password) {
        Admin admin = adminService.findByLoginNameAndPassword(loginName, password);
        if (admin != null) {
            //生成token
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            Map map = new HashMap();
            map.put("token", token);
            map.put("name", admin.getLoginname());//登陆名
            return new Result(true, StatusCode.OK.getCode(), "登陆成功", map);
        }
        return new Result(false, StatusCode.LOGINERROR.getCode(), "用户名或密码错误");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", adminService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", adminService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Admin> pageList = adminService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK.getCode(), "查询成功", new PageResult<Admin>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", adminService.findSearch(searchMap));
    }

    /**
     * 增加
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return new Result(true, StatusCode.OK.getCode(), "增加成功");
    }

    /**
     * 修改
     *
     * @param admin
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Admin admin, @PathVariable String id) {
        admin.setId(id);
        adminService.update(admin);
        return new Result(true, StatusCode.OK.getCode(), "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id, HttpServletRequest request) {
        String token = (String) request.getAttribute("claims_admin");
        if (StringUtils.isEmpty(token)) {
            return new Result(true, StatusCode.ACCESSERROR.getCode(), "无权访问");
        }
        adminService.deleteById(id);
        return new Result(true, StatusCode.OK.getCode(), "删除成功");
    }

}
