package com.lujiahao.template;

import org.elasticsearch.action.update.UpdateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTemplateServiceTest {
    @Autowired
    private ElasticsearchTemplateService elasticsearchTemplateService;

    @Test
    public void save() {
        Person person = new Person();
        person.setId(new Random().nextLong());
        person.setName("haha");
        String save = elasticsearchTemplateService.save(person);
        System.out.println(save);
    }

    @Test
    public void deleteByName() {
        elasticsearchTemplateService.deleteByName("lujiahao");
    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId(-5264182431891613084L);
        person.setName("hahaaaaaaaaa");
        UpdateResponse update = elasticsearchTemplateService.update(person);
        System.out.println(update);
    }

    @Test
    public void getAll() {
        List<Person> all = elasticsearchTemplateService.getAll();
        System.out.println(all);
    }

    @Test
    public void getByName() {
        List<Person> haha = elasticsearchTemplateService.getByName("haha");
        System.out.println(haha);
    }

    @Test
    public void pageQueryByName() {
    }
}