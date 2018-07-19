package com.lujiahao.springbootmybatis;

import com.lujiahao.springbootmybatis.domain.User;
import com.lujiahao.springbootmybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setUserName("lujiahao");
        user.setUserAge(10);
        int resultCount = userMapper.insertUser(user);
        System.out.println("插入数据影响行数:" + resultCount);

        List<User> userList = userMapper.findUserByName("lujiahao");
        User userById = userList.get(0);
        System.out.println("查找数据:" + userById);

        userById.setUserName("lujiahao");
        userById.setUserAge(18);
        int i = userMapper.updateUser(userById);
        System.out.println("更新数据影响行数:" + i);

        List<User> userList1 = userMapper.findUserByName("lujiahao");
        User userNew = userList1.get(0);
        System.out.println("查找更新后数据:" + userNew);

        userMapper.deleteUser("lujiahao");
    }
}