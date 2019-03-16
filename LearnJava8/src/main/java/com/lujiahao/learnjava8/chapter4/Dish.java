package com.lujiahao.learnjava8.chapter4;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lujiahao
 * @date 2019-03-08 11:46
 */
@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public enum Type { MEAT, FISH, OTHER }


}
