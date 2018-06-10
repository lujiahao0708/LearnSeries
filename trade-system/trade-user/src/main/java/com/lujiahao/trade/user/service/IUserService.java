package com.lujiahao.trade.user.service;

import com.lujiahao.trade.common.protocol.user.QueryUserReq;
import com.lujiahao.trade.common.protocol.user.QueryUserRes;

/**
 * @author lujiahao
 * @date 2018-06-07 下午2:11
 */
public interface IUserService {

    QueryUserRes queryUserById(QueryUserReq queryUserReq);
}
