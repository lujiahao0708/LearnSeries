package com.lujiahao.es_company.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author lujiahao
 * @date 2018-11-26 15:35
 */
@Data
@Document(indexName = "company", type = "employee")
public class EmployeeDocument {

    @Id
    private Long id;

    private String name;
    private Integer age;

}