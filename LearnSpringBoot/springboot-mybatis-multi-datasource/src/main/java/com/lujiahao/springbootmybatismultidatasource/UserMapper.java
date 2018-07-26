package com.lujiahao.springbootmybatismultidatasource;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lujiahao
 * @date 2017-12-08 下午4:46
 */
public interface UserMapper {

    @Select("select * from user where name = #{userName}")
    @Results({
            @Result(property = "userName",column = "name"),
            @Result(property = "userAge", column = "age")
    })
    List<User> findUserByName(@Param("userName") String userName);

    int insertUser(User user);

    @Update("update user set name=#{userName},age=#{userAge} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where name=#{userName}")
    void deleteUser(@Param("userName") String name);
}
