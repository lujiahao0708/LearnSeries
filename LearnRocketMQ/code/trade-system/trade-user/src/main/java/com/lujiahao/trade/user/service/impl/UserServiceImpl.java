package com.lujiahao.trade.user.service.impl;

import com.lujiahao.trade.common.constants.TradeEnum;
import com.lujiahao.trade.common.protocol.user.QueryUserReq;
import com.lujiahao.trade.common.protocol.user.QueryUserRes;
import com.lujiahao.trade.dao.entity.TradeUser;
import com.lujiahao.trade.dao.mapper.TradeUserMapper;
import com.lujiahao.trade.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lujiahao
 * @date 2018-06-07 下午2:11
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private TradeUserMapper tradeUserMapper;

    @Override
    public QueryUserRes queryUserById(QueryUserReq queryUserReq) {
        QueryUserRes queryUserRes = new QueryUserRes();
        queryUserRes.setRetCode(TradeEnum.RetEnum.SUCCESS.getCode());
        queryUserRes.setRetInfo(TradeEnum.RetEnum.SUCCESS.getDesc());
        try {
            if (queryUserReq == null || queryUserReq.getUserId() == null) {
                throw new RuntimeException("请求参数不正确");
            }

            TradeUser user = tradeUserMapper.selectByPrimaryKey(1);
//            TradeUser user = tradeUserMapper.selectByPrimaryKey(queryUserReq.getUserId());
            if (user == null) {
                throw new RuntimeException("未查询到用户信息");
            }
            BeanUtils.copyProperties(user, queryUserRes);
        } catch (Exception e) {
            queryUserRes.setRetCode(TradeEnum.RetEnum.FAIL.getCode());
            queryUserRes.setRetInfo(TradeEnum.RetEnum.FAIL.getDesc());
            e.printStackTrace();
        }
        return queryUserRes;
    }
}
