package com.lujiahao.learnjava8;

/**
 * @author lujiahao
 * @date 2018-12-17 15:26
 */
public class Test {
//    public static void main(String[] args) {
//        VariantTest v1 = new VariantTest();
//        VariantTest v2 = new VariantTest();
//    }

    public static void main(String[] args) {
        //go(new MyBase());

        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }

    static void go(Base b){
        b.add(8);
    }
}





