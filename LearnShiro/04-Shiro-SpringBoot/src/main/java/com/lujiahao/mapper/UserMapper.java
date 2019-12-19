package com.lujiahao.mapper;

import com.lujiahao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019/10/15
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where username = #{username}")
    User findByUserName(String username);
}