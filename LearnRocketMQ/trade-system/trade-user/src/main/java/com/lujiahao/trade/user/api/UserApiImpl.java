package com.lujiahao.trade.user.api;

import com.lujiahao.trade.common.api.IUserApi;
import com.lujiahao.trade.common.protocol.user.ChangeUserMoneyReq;
import com.lujiahao.trade.common.protocol.user.ChangeUserMoneyRes;
import com.lujiahao.trade.common.protocol.user.QueryUserReq;
import com.lujiahao.trade.common.protocol.user.QueryUserRes;
import com.lujiahao.trade.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lujiahao
 * @date 2018-06-07 下午2:10
 */
@RestController
public class UserApiImpl implements IUserApi {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/queryUserById")
    public QueryUserRes queryUserById(QueryUserReq queryUserReq) {
        return userService.queryUserById(queryUserReq);
    }

    @Override
    public ChangeUserMoneyRes changeUserMoney(ChangeUserMoneyReq changeUserMoneyReq) {
        return null;
    }
}
