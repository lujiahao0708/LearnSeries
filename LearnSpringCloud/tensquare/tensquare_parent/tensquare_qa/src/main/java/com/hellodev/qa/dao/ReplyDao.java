package com.hellodev.qa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hellodev.qa.pojo.Reply;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ReplyDao extends JpaRepository<Reply,String>,JpaSpecificationExecutor<Reply>{
	
}
