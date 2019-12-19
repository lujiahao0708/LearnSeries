package com.lujiahao.service;

import com.lujiahao.bean.User;
import com.lujiahao.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2019-09-29 18:37
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User query4Login(User user) {
        return userDao.query4Login(user);
    }

    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    public void deleteUsers(Map<String, Object> map) {
        userDao.deleteUsers(map);
    }

    public void deleteUserRoles(Map<String, Object> map) {
        userDao.deleteUserRoles(map);
    }

    public void insertUserRoles(Map<String, Object> map) {
        userDao.insertUserRoles(map);
    }

    public List<Integer> queryRoleidsByUserid(Integer id) {
        return userDao.queryRoleidsByUserid(id);
    }

    public User queryByToken(String token) {
        return userDao.queryByToken(token);
    }
}
