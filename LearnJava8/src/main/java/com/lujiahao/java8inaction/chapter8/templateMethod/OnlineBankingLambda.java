package com.lujiahao.java8inaction.chapter8.templateMethod;

import com.lujiahao.java8inaction.DataUtil;

import java.util.function.Consumer;

/**
 * @author lujiahao
 * @date 2019-03-18 17:02
 */
public class OnlineBankingLambda {
    public void processCustomer(int id, Consumer<Customer> consumer) {
        Customer c = DataUtil.getCustomerWithId(id);
        consumer.accept(c);
    }
}
