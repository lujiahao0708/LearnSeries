package com.lujiahao.mapper;

import com.lujiahao.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019/10/15
 */
@Mapper
public interface RolePermissionMapper {

    @Select("select * from role_permission where rid = #{rid}")
    List<RolePermission> getRolePermissionByRid(Integer rid);

    @Select("<script> select * from role_permission where rid in " +
            "<foreach item='item' collection='ridList' open='(' separator=',' close=')'> #{item} </foreach> </script>")
    List<RolePermission> getRolePermissionByRids(@Param("ridList") List<Integer> ridList);
}