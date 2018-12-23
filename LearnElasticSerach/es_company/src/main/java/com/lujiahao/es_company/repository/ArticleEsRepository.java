package com.lujiahao.es_company.repository;

import com.lujiahao.es_company.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ArticleEsRepository class
 * 实现Article在es中的crud、分页、排序、高亮关键字
 *
 */
@Repository
public interface ArticleEsRepository extends ElasticsearchRepository<Article,Long> {

}