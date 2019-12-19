package com.lujiahao.mapper;

import com.lujiahao.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("<script> select * from permission where id in " +
            "<foreach item='item' collection='pidList' open='(' separator=',' close=')'> #{item} </foreach> </script>")
    List<Permission> getPermissionsByIds(@Param("pidList") List<Long> pidList);
}