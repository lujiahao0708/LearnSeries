package com.lujiahao.learnjava8.chapter8.chainOfResponsibility;

/**
 * @author lujiahao
 * @date 2019-03-18 17:19
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
