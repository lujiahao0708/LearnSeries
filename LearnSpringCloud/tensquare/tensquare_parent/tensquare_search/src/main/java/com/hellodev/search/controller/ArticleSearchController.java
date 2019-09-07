package com.hellodev.search.controller;

import com.hellodev.common.entity.PageResult;
import com.hellodev.common.entity.Result;
import com.hellodev.common.entity.StatusCode;
import com.hellodev.search.pojo.Article;
import com.hellodev.search.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author lujiahao
 * @date 2019-09-07 11:43
 */
@RestController
@CrossOrigin
@RequestMapping("/search")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleSearchService.save(article);
        return new Result(true, StatusCode.OK.getCode(), "操作成功");
    }

    @RequestMapping(value = "/{keywords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true, StatusCode.OK.getCode(), "查询成功",
                new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
    }
}