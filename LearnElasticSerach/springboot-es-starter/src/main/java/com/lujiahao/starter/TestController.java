package com.lujiahao.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lujiahao
 * @date 2019-04-09 22:03
 */
@RestController
public class TestController {

    @Autowired
    private PersonEsRepository repository;

    @GetMapping("/addPerson")
    public void addPerson() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(new Random().nextLong());
            person.setName("lujiahao");
            person.setAge(i);
            personList.add(person);
        }
        Iterable<Person> people = repository.saveAll(personList);
        for (Person person : people) {
            System.out.println(person);
        }
    }

    @GetMapping("/getAllPerson")
    public List<Person> getPerson(String name) {
        List<Person> personByName = repository.findPersonByName(name);
        return personByName;
    }
}
