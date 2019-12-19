package OutOfMemory;

/**
 * 创建线程导致内存溢出   危险!!! 可能导致死机
 * VM Args: -Xss2M
 * @author lujiahao
 * @date 2018-12-21 17:11
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
