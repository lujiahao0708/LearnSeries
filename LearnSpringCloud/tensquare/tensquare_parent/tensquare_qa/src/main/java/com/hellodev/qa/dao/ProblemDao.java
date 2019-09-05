package com.hellodev.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hellodev.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    // 使用sql语句
    @Query(value = "select * from tb_problem,tb_pl where id = problemid and labelid = ? order by replytime desc", nativeQuery = true)
    public Page<Problem> newList(String labelId, Pageable pageable);

    @Query(value = "select * from tb_problem,tb_pl where id = problemid and labelid = ? order by reply desc", nativeQuery = true)
    public Page<Problem> hotList(String labelId, Pageable pageable);

    @Query(value = "select * from tb_problem,tb_pl where id = problemid and labelid = ? and reply=0 order by createtime desc", nativeQuery = true)
    public Page<Problem> waitList(String labelId, Pageable pageable);
}
