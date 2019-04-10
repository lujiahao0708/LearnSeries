package com.lujiahao.starter;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonEsRepository extends ElasticsearchRepository<Person,Long> {

    List<Person> findPersonByName(String name);


}