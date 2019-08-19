package com.lujiahao.service.impl;

/**
 * @author lujiahao
 * @date 2019-07-21 13:05
 */

import com.lujiahao.dao.DeptDao;
import com.lujiahao.entities.Dept;
import com.lujiahao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
