package com.lujiahao.learnjava8.chapter8.chainOfResponsibility;

/**
 * @author lujiahao
 * @date 2019-03-18 17:18
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
