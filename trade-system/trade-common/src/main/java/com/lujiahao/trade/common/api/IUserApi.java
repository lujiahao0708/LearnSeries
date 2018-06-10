package com.lujiahao.trade.common.api;

import com.lujiahao.trade.common.protocol.user.QueryUserRes;
import com.lujiahao.trade.common.protocol.user.QueryUserReq;

/**
 * @author lujiahao
 * @date 2018-06-07 下午1:49
 */
public interface IUserApi {

    QueryUserRes queryUserById(QueryUserReq queryUserReq);
}
