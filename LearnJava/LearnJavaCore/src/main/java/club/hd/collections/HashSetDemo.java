package club.hd.collections;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lujiahao
 * @date 2019/11/11
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("A");

        System.out.println(set.toString());
    }
}
