package com.lujiahao.learnjava8.chapter8.strategy;

/**
 * @author lujiahao
 * @date 2019-03-18 16:21
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumber());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b1 + " " + b2);

        Validator numericValidator1 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b11 = numericValidator1.validate("aaaa");
        Validator lowerCaseValidator1 = new Validator((String s) -> s.matches("\\d+"));
        boolean b21 = lowerCaseValidator.validate("bbbb");
        System.out.println(b11 + " " + b21);
    }
}
