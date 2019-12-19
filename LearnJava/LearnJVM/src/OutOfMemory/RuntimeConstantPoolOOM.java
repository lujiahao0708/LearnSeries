package OutOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致内存溢出
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10M
 * jdk1.6
 *
 * 使用新版本的jdk会输出:
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10m; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
 *
 * @author lujiahao
 * @date 2018-12-21 17:33
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持炸常量池引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB的PermSize在Integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
