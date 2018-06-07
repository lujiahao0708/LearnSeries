package com.lujiahao.trade.dao;

import com.lujiahao.trade.dao.mapper.TradeUserMapper;
import com.lujiahao.trade.dao.model.TradeUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTestCase.class);

    @Autowired
    private TradeUserMapper tradeUserMapper;

    @Test
    public void test() {
        TradeUser user = new TradeUser();
        user.setUserName("lujiahao");
        tradeUserMapper.insert(user);

    }
}
