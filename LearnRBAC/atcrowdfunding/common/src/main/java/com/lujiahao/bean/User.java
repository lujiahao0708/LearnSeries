package com.lujiahao.bean;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2019-09-30 21:24
 */
@Data
public class User {

    private Integer id;
    private String username;

    private String email;
    private String loginacct;
    private String userpswd;
    private String token;

    private String createtime;
}
