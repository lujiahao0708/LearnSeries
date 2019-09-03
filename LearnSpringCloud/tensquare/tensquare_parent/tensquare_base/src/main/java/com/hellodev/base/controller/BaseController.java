package com.hellodev.base.controller;

import com.hellodev.base.pojo.Label;
import com.hellodev.entity.Result;
import com.hellodev.entity.StatusCode;
import org.springframework.web.bind.annotation.*;

/**
 * @author lujiahao
 * @date 2019-09-03 19:12
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class BaseController {

    @GetMapping
    public Result findAll() {
        return Result.builder().flag(true).code(StatusCode.OK.getCode()).message("查询成功").build();
    }

    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String id) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功");
    }

    @PostMapping
    public Result save(@RequestBody Label label) {
        return new Result(true, StatusCode.OK.getCode(), "添加成功");
    }

    @PutMapping("/{labelId}")
    public Result update(@PathVariable("labelId") String id, @RequestBody Label label) {
        return new Result(true, StatusCode.OK.getCode(), "修改成功");
    }

    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable("labelId") String id) {
        return new Result(true, StatusCode.OK.getCode(), "删除成功");
    }

    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功");
    }

    @PostMapping("/search/{page}/{size}")
    public Result pageQuery(@RequestBody Label label, @PathVariable("page") int currentPage, @PathVariable("size") int pageSize) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功");
    }
}
