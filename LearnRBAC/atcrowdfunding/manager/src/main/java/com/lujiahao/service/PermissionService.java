package com.lujiahao.service;

import com.lujiahao.bean.Permission;
import com.lujiahao.bean.User;
import com.lujiahao.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService{

	@Autowired
	private PermissionDao permissionDao;

	public Permission queryRootPermission() {
		return permissionDao.queryRootPermission();
	}

	public List<Permission> queryChildPermissions(Integer pid) {
		return permissionDao.queryChildPermissions(pid);
	}

	public List<Permission> queryAll() {
		return permissionDao.queryAll();
	}

	public void insertPermission(Permission permission) {
		permissionDao.insertPermission(permission);
	}

	public Permission queryById(Integer id) {
		return permissionDao.queryById(id);
	}

	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	public void deletePermission(Permission permission) {
		permissionDao.deletePermission(permission);
	}

	public List<Integer> queryPermissionidsByRoleid(Integer roleid) {
		return permissionDao.queryPermissionidsByRoleid(roleid);
	}

	public List<Permission> queryPermissionsByUser(User dbUser) {
		return permissionDao.queryPermissionsByUser(dbUser);
	}
}
