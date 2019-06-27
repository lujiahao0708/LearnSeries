package com.lujiahao.shiromybatish2.service;

import com.lujiahao.shiromybatish2.domain.User;
import com.lujiahao.shiromybatish2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2019-06-26 23:05
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
