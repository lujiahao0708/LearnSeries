package com.lujiahao.springbootshiro.domain;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2019-06-26 23:01
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String perms;
}
