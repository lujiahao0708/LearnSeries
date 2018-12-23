package OutOfMemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出(使用unsafe分配本机内存)
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author lujiahao
 * @date 2018-12-21 17:51
 */
public class DirectMemoryOOM {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
