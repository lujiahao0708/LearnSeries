package chapter7.code_7_2;

/**
 * @author lujiahao
 * @date 2019-09-04 15:20
 */
public class NotInitializationDemo3 {

    public static void main(String[] args) {
        /**
         * 虽然引用了ConstClass的常量,但是编译时就将磁场量值存储到NotInitializationDemo3的常量池中,
         */
        System.out.println(ConstClass.HELLOWORLD);
    }
}
