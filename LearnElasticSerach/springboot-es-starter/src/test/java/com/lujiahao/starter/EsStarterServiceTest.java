package com.lujiahao.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsStarterServiceTest {
    @Autowired
    private EsStarterService esStarterService;

    @Test
    public void save() {
        Person person = new Person();
        person.setId(new Random().nextLong());
        person.setName("lujiahao");
        esStarterService.save(person);
    }

    @Test
    public void delete() {
        Person person = new Person();
        person.setId(-5264182431891613084L);
        person.setName("lujiahao123456");
        esStarterService.delete(person);
    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId(542136934419565287L);
        person.setName("lujiahao123456");
        esStarterService.update(person);
    }

    @Test
    public void findAll() {
        Iterable<Person> all = esStarterService.findAll();
        all.forEach(System.out::println);
    }
}