package com.hellodev.article.dao;

import com.hellodev.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论Dao
 * @author lujiahao
 * @date 2019-09-06 15:34
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    /**
     * 根据文章ID查询评论列表
     */
    public List<Comment> findByArticleid(String articleid);
}
