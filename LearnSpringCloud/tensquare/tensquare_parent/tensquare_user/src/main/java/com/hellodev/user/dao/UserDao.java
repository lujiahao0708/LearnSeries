package com.hellodev.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hellodev.user.pojo.User;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    /**
     * 根据手机号查询用户
     */
    public User findByMobile(String mobile);
}
