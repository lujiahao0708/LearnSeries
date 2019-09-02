package com.hellodev.dao;

import com.hellodev.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * <h2>根据用户名查找用户记录</h2>
     * */
    AdUser findByUsername(String username);
}
