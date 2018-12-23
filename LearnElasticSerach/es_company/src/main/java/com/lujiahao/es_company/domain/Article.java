package com.lujiahao.es_company.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Article class
 *
 */
@Data
@Document(indexName = "blog", type = "article")
public class Article implements Serializable{
    private Long id;
    private String title;
    private String content;
    private String summary;
    private int pv;
    private String author;
}