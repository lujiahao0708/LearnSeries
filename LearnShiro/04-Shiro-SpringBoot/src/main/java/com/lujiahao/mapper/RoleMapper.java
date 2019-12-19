package com.lujiahao.mapper;

import com.lujiahao.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select({"<script> select * from role where id in ",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'> #{id} </foreach> </script>"})
    List<Role> getRolesByIds(@Param("ids") List<Long> ids);

}