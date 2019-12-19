package chapter7.code_7_2;

/**
 * @author lujiahao
 * @date 2019-09-04 14:55
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    // 准备阶段为类的静态变量分配内存,并将其初始化为默认值
    // 初始化阶段为类的静态变量赋予正确的初始值
    public static int value = 123;
}
