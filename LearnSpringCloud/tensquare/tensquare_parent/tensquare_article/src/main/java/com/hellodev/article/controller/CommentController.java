package com.hellodev.article.controller;

import com.hellodev.article.pojo.Comment;
import com.hellodev.article.service.CommentService;
import com.hellodev.common.entity.Result;
import com.hellodev.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lujiahao
 * @date 2019-09-06 15:35
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK.getCode(), "提交成功");
    }

    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", commentService.findByArticleid(articleid));
    }
}
