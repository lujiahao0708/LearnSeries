package com.lujiahao.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2019-04-10 16:59
 */
@Service
public class EsStarterService {

    @Autowired
    private PersonEsRepository repository;

    /**
     * 增
     */
    public Person save(Person person) {
        return repository.save(person);
    }

    /**
     * 删
     */
    public void delete(Person person) {
        repository.delete(person);
    }

    /**
     * 改
     */
    public Person update(Person person) {
        return repository.save(person);
    }

    /**
     * 查
     */
    public Iterable<Person> findAll() {
        return repository.findAll();
    }
}
