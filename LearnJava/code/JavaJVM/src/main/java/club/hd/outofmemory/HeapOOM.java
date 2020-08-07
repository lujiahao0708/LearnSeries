package club.hd.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 堆内存溢出
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author lujiahao
 * @date 2018-12-21 14:47
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(list.size());
        }
    }
}
