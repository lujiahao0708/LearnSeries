package com.lujiahao.java8inaction.chapter8.chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author lujiahao
 * @date 2019-03-18 17:20
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
//        ProcessingObject<String> p1 = new HeaderTextProcessing();
//        ProcessingObject<String> p2 = new SpellCheckerProcessing();
//        p1.setSuccessor(p2);
//        String result = p1.handle("Aren't labdas really sexy?!!");
//        System.out.println(result);

//        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
//        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
//        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
//        String result1 = pipeline.apply("Aren't labdas really sexy?!!");
//        System.out.println(result1);

        Param param = new Param(0, 2);
        UnaryOperator<Result> headerProcessing = (Result result) -> {
            if (!result.getChainFlag()) {
                System.out.println("chainFlag:" + result.getChainFlag() + " 链结束!");
                return result;
            }
            System.out.println("链执行 headerProcessing des:" + result.getDes());
            return result;
        };
        UnaryOperator<Result> spellCheckerProcessing = (Result result) -> {
            if (!result.getChainFlag()) {
                System.out.println("chainFlag:" + result.getChainFlag() + " 链结束!");
                return result;
            }
            if (param.getCode() > 0) {
                result.setDes("code > 0");
                result.setChainFlag(true);
            } else {
                result.setDes("code <= 0");
                result.setChainFlag(false);
            }
            System.out.println("链执行 spellCheckerProcessing des:" + result.getDes());
            return result;
        };

        UnaryOperator<Result> test = (Result result) -> {
            if (!result.getChainFlag()) {
                System.out.println("chainFlag:" + result.getChainFlag() + " 链结束!");
                return result;
            }
            if (param.getCode() > 0) {
                result.setDes("codesss > 0");
                result.setChainFlag(true);
            } else {
                result.setDes("codessss <= 0");
                result.setChainFlag(false);
            }
            System.out.println("链执行 test des:" + result.getDes());
            return result;
        };

        Function<Result, Result> r1 = headerProcessing.andThen(spellCheckerProcessing).andThen(test);
        Result ss = r1.apply(new Result("ss", true));
        if (!ss.getChainFlag()) {
            System.out.println("desc:" + ss.getDes() + " chainFlag:" + ss.getChainFlag());
            return;
        }
        System.out.println("desc:" + ss.getDes() + " chainFlag:" + ss.getChainFlag());

//        Function<Result, Result> resultFunction = r1.andThen(test);
//        Result za = resultFunction.apply(new Result("za"));
//        System.out.println(za.getDes() + " " + za.getChainFlag());
//        Result apply = resultResultFunction.apply(new Result("Aren't labdas really sexy?!!"));
//        System.out.println(apply.getDes());
    }

    static class Result{
        private String des;
        private boolean chainFlag;

        public Result(String des, boolean chainFlag) {
            this.des = des;
            this.chainFlag = chainFlag;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public boolean getChainFlag() {
            return chainFlag;
        }

        public void setChainFlag(boolean chainFlag) {
            this.chainFlag = chainFlag;
        }
    }

    static class Param{
        private Integer code;
        private Integer code2;

        public Param(Integer code, Integer code2) {
            this.code = code;
            this.code2 = code2;
        }

        public Integer getCode() {
            return code;
        }

        public Integer getCode2() {
            return code2;
        }
    }
}
