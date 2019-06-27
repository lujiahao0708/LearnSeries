package com.lujiahao.shirofirst.chapter6.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lujiahao
 * @date 2019-06-26 16:57
 */
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String salt;

    private Boolean locked = Boolean.FALSE;

    public String getCredentialsSalt() {
        return username + salt;
    }
}
