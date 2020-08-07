package club.hd.chapter3;

/**
 * 大对象直接进入老年代
 * 虚拟机参数
 *      -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 *      -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @author lujiahao
 * @date 2020-08-07
 */
public class _3_6_2_TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
/**
 * TODO 这个没有生效,不知道为什么
 *
 * -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:NewSize=10485760
 * -XX:PretenureSizeThreshold=3145728 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseSerialGC
 * Heap
 *  def new generation   total 9216K, used 5936K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   eden space 8192K,  72% used [0x00000007bec00000, 0x00000007bf1cc168, 0x00000007bf400000)
 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 *  tenured generation   total 10240K, used 0K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *    the space 10240K,   0% used [0x00000007bf600000, 0x00000007bf600000, 0x00000007bf600200, 0x00000007c0000000)
 *  Metaspace       used 2973K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
 */