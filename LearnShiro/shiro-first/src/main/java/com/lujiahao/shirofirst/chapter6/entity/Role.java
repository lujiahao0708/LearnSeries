package com.lujiahao.learnshiro.chapter6.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lujiahao
 * @date 2019-06-26 16:56
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

}
