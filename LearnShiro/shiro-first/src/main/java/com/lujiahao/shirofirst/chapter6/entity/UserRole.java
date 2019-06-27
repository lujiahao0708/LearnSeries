package com.lujiahao.shirofirst.chapter6.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关系
 * @author lujiahao
 * @date 2019-06-26 16:58
 */
@Data
public class UserRole implements Serializable {
    private Long userId;
    private Long roleId;
}
