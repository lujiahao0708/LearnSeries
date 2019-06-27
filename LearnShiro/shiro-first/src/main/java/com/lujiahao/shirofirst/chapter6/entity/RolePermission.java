package com.lujiahao.learnshiro.chapter6.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关系
 * @author lujiahao
 * @date 2019-06-26 16:57
 */
@Data
public class RolePermission implements Serializable {

    private Long roleId;
    private Long permissionId;

}
