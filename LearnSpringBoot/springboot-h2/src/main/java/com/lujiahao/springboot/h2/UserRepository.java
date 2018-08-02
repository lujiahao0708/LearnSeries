package com.lujiahao.springboot.h2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户仓库
 * @author lujiahao
 * @date 2018/8/1
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
