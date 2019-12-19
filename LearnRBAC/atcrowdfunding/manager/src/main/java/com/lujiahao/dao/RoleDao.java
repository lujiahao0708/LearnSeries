package com.lujiahao.dao;

import com.lujiahao.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	@Select("select * from t_role")
	List<Role> queryAll();

	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermissions(Map<String, Object> paramMap);

	void insertRole(Role role);
}
