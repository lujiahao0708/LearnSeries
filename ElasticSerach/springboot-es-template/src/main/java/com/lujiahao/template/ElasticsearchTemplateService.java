package com.lujiahao.template;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lujiahao
 * @date 2018-11-01 13:55
 */
@Service
public class ElasticsearchTemplateService {

    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    private static final String INDEX_NAME = "person";
    private static final String TYPE_NAME = "chinese";
    /**
     * 增
     */
    public String save(Person person) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withIndexName(INDEX_NAME)
                .withType(TYPE_NAME)
                .withId(String.valueOf(person.getId()))
                .withObject(person)
                .build();
        String index = elasticsearchTemplate.index(indexQuery);
        System.out.println("xxxxxxxxxxxx " + index);
        return index;
    }

    /**
     * 删
     */
    public void deleteByName(String name) {
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.setQuery(QueryBuilders.matchQuery("name", name));
        deleteQuery.setIndex(INDEX_NAME);
        deleteQuery.setType(TYPE_NAME);
        elasticsearchTemplate.delete(deleteQuery);
    }

    /**
     * 改
     */
    public UpdateResponse update(Person person) {
        try {
            UpdateRequest updateRequest = new UpdateRequest()
                    .index(INDEX_NAME)
                    .type(TYPE_NAME)
                    .id(String.valueOf(person.getId()))
                    .doc(XContentFactory.jsonBuilder()
                            .startObject()
                            .field("name", person.getName())
                            .endObject());

            UpdateQuery updateQuery = new UpdateQueryBuilder()
                    .withIndexName(INDEX_NAME)
                    .withType(TYPE_NAME)
                    .withId(String.valueOf(person.getId()))
                    .withClass(Person.class)
                    .withUpdateRequest(updateRequest)
                    .build();

            UpdateResponse update = elasticsearchTemplate.update(updateQuery);
            return update;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 查
     */
    public List<Person> getAll() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Person.class);
    }

    public List<Person> getByName(String name) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", name))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Person.class);
    }

    public Page<Person> pageQueryByName(Integer pageNo, Integer pageSize, String keyword) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", keyword))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return elasticsearchTemplate.queryForPage(searchQuery, Person.class);
    }

}
