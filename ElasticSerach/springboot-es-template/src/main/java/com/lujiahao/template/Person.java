package com.lujiahao.template;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "person", type = "chinese")
public class Person implements Serializable{
    private static final long serialVersionUID = -6804453833406105286L;

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String address;
}