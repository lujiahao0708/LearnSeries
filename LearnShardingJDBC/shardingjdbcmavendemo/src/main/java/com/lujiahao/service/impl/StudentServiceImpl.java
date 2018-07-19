package com.lujiahao.service.impl;

import com.lujiahao.entity.Student;
import com.lujiahao.mapper.StudentMapper;
import com.lujiahao.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lujiahao
 * @date 2018-07-09 上午11:59
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }


}
