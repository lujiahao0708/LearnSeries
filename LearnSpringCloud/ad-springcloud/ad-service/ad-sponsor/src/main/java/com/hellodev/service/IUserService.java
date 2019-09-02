package com.hellodev.service;

import com.hellodev.exception.AdException;
import com.hellodev.vo.CreateUserRequest;
import com.hellodev.vo.CreateUserResponse;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
