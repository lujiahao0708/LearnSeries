package club.hd.chapter3;

/**
 * 长期存活的对象将进入老年代
 * 虚拟机参数
 *      -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 *      -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * @author lujiahao
 * @date 2020-08-07
 */
public class _3_6_3_TestTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        // allocation3 对象是 4M,新生代内存不够触发 Minor GC,
        // s0区域空间无法同时存储 a1 和 a2,只能存储 a1,a2 则进入老年代
        // 此时 allocation1 的年龄值是 1
        // Minor GC 完成后 a3 放入 eden 区
        allocation3 = new byte[4 * _1MB];
        // allocation3 置空,失去 GC Roots,下次GC 将回收 eden 中的 4M 空间
        allocation3 = null;
        // 放入大对象到新生代,新生代空间不足,触发 Minor GC
        // 首先回收4M 空间
        // 如果此时 -XX:MaxTenuringThreshold=1,由于之前 a1 的年龄已经是 1,因此 a1 进入老年代;此时新生代内存为 0,老年代中有 a1 和 a2
        // 再分配 4M 空间,并将空间地址放入 a3,此时新生代内存中 a3 占用 4M
        allocation3 = new byte[4 * _1MB];
    }
}
/**
 * -XX:InitialHeapSize=20971520 -XX:InitialTenuringThreshold=1 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760
 * -XX:MaxTenuringThreshold=1 -XX:NewSize=10485760 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseSerialGC
 * [GC (Allocation Failure) [DefNew: 5858K->625K(9216K), 0.0072897 secs] 5858K->4722K(19456K), 0.0073470 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
 * [GC (Allocation Failure) [DefNew: 4803K->0K(9216K), 0.0015284 secs] 8899K->4710K(19456K), 0.0015512 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * Heap
 *  def new generation   total 9216K, used 4315K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf036cc0, 0x00000007bf400000)
 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400228, 0x00000007bf500000)
 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 *  tenured generation   total 10240K, used 4710K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *    the space 10240K,  45% used [0x00000007bf600000, 0x00000007bfa99988, 0x00000007bfa99a00, 0x00000007c0000000)
 *  Metaspace       used 2971K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 327K, capacity 388K, committed 512K, reserved 1048576K
 */
