package com.lujiahao.service;

import com.lujiahao.mapper.UserMapper;
import com.lujiahao.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lujiahao
 * @date 2019/10/16
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }

}
