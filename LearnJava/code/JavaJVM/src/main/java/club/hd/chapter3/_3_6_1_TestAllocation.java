package club.hd.chapter3;

/**
 * 对象优先在 Eden 区分布
 * 虚拟机参数
 *      -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * @author lujiahao
 * @date 2019-01-03 22:25
 */
public class _3_6_1_TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        // 出现一次Minor GC
        allocation4 = new byte[4 * _1MB];
    }
}
/**
 * [GC (Allocation Failure) [DefNew: 7649K->369K(9216K), 0.0056134 secs] 7649K->6513K(19456K), 0.0056532 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
 * Heap
 *  def new generation   total 9216K, used 4630K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf0290f0, 0x00000007bf400000)
 *   from space 1024K,  36% used [0x00000007bf500000, 0x00000007bf55c768, 0x00000007bf600000)
 *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 *  tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *    the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
 *  Metaspace       used 2950K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 322K, capacity 388K, committed 512K, reserved 1048576K
 */
