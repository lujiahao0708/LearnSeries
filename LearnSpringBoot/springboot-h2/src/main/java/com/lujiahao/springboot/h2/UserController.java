package com.lujiahao.springboot.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lujiahao
 * @date 2018-08-02 下午1:48
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Map<String, Object> findById() {
        Map<String, Object> result = new HashMap<>();
        List<User> all = userRepository.findAll();
        result.put("userList", all);
        return result;
    }

    @GetMapping("/user/{id}")// 注意，此处使用的是GetMapping注解，该注解的作用类似与@RequestMapping(value="/user/{id}" ,method=RequestMethod.GET)，@PostMapping注解同理
    public User findById(@PathVariable Long id) {
        return this.userRepository.findOne(id);
    }
}

