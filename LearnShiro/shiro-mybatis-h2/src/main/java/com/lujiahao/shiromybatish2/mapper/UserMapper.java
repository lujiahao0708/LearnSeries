package com.lujiahao.springbootshiro.mapper;

import com.lujiahao.springbootshiro.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lujiahao
 * @date 2019-06-26 23:01
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name=#{name} ")
    User findByName(String name);

    @Select("select * from user where id=#{id} ")
    User findById(Integer id);
}
