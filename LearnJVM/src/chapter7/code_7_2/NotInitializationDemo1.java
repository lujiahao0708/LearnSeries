package chapter7.code_7_2;

/**
 *
 * @author lujiahao
 * @date 2019-09-04 14:56
 */
public class NotInitializationDemo1 {

    public static void main(String[] args) {

        System.out.println(SubClass.value);

        int value = SubClass.value;
        System.out.println(value);
    }
}
