package com.lujiahao.service;

import com.lujiahao.BaseServletTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ESSearchServiceTest extends BaseServletTest {

    @Autowired
    private ESSearchService esSearchService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void buildIndex() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String format = sdf.format(new Date());
        System.out.println(format);
        boolean b = esSearchService.buildIndex("order_" + format);
        System.out.println(b);
    }

    @Test
    public void delIndex() {
    }

    @Test
    public void searchDataByParam() {
    }

    @Test
    public void updateDataById() {
    }

    @Test
    public void addTargetDataALL() {
    }

    @Test
    public void delDataById() {
    }

    @Test
    public void isIndexExist() {
        boolean lujiahao = esSearchService.isIndexExist("lujiahao");
        System.out.println(lujiahao);
    }
}