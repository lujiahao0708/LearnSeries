package club.hd.string;

/**
 * String不可变
 * @author lujiahao
 * @date 2019/11/7
 */
public class StringImmutableDemo {
    public static void main(String[] args) {
        String s = "Hello";
        String s2 = s;
        System.out.println("原始s值:" + s);
        System.out.println("原始s2值:" + s2);

        s = s.concat("World");

        System.out.println("现在s值:" + s);
        System.out.println("现在s2值:" + s2);
    }
}
