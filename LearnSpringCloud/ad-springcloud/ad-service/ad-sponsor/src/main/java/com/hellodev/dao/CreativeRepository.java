package com.hellodev.dao;

import com.hellodev.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
