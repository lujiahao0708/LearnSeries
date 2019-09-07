package com.hellodev.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * 文章实体类
 *
 * @author lujiahao
 * @date 2019-09-07 11:38
 */
@Data
@Document(indexName = "tensquare_article", type = "article")
public class Article implements Serializable {
    @Id
    private String id;//ID
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;//标题
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;//文章正文
    private String state;//审核状态
}