package com.lujiahao.learnjava8.chapter8.templateMethod;

import com.lujiahao.learnjava8.DataUtil;

/**
 * @author lujiahao
 * @date 2019-03-18 16:53
 */
public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = DataUtil.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}
