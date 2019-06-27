package com.lujiahao.learnshiro.chapter6.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lujiahao
 * @date 2019-06-26 16:53
 */
@Data
public class Permission implements Serializable {
    private Long id;

    // 权限标识,程序中判断使用,如 user:create
    private String permission;

    // 权限描述,UI界面中展示
    private String description;

    // 是否可用,如果不可用将不会添加给用户
    private Boolean available = Boolean.FALSE;
}
