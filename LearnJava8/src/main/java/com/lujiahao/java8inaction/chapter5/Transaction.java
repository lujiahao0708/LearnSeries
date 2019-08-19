package com.lujiahao.java8inaction.chapter5;

import lombok.Data;

/**
 * @author lujiahao
 * @date 2019-03-11 17:18
 */
@Data
public class Transaction {
    public final Trader trader;
    public final int year;
    public final int value;
}
