package com.hellodev.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hellodev.user.pojo.Admin;
/**
 * 数据访问接口
 */
public interface AdminDao extends JpaRepository<Admin,String>,JpaSpecificationExecutor<Admin>{

    public Admin findByLoginname(String loginName);
}
