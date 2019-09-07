package com.hellodev.search.dao;

import com.hellodev.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 文章数据访问层接口
 *
 * @author lujiahao
 * @date 2019-09-07 11:42
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {

    /**
     * 检索
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}