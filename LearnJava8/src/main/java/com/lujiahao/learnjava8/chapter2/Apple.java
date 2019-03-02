package com.lujiahao.learnjava8.chapter2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lujiahao
 * @date 2019-02-19 18:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    private String color;
    private Long weight;
}
