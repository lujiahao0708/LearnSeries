package chapter7.code_7_2;

/**
 * @author lujiahao
 * @date 2019-09-04 15:20
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}
