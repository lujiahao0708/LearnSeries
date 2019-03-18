package com.lujiahao.learnjava8.chapter8.chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author lujiahao
 * @date 2019-03-18 17:20
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result1 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result1);

    }
}
