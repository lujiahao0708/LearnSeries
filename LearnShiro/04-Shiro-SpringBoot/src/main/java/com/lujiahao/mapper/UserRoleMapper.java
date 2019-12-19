package com.lujiahao.mapper;

import com.lujiahao.pojo.Role;
import com.lujiahao.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019/10/15
 */
@Mapper
public interface UserRoleMapper {

    @Select("select * from user_role where uid = #{uid}")
    List<UserRole> getUserRoleByUid(Integer uid);
}