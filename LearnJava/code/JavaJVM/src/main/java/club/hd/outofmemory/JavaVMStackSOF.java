package club.hd.outofmemory;

/**
 * 虚拟机栈和本地方法栈溢出
 * 线程请求的栈深度大于虚拟机允许的栈最大深度  StackOverflowError
 * VM Args: -Xss256k
 *
 * 设置128k,启动会报上面的问题
 * The stack size specified is too small, Specify at least 160k
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 *
 * @author lujiahao
 * @date 2018-12-21 17:02
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
/**
 * 输出结果
 * stack length:2015
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at club.hd.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:22)
 * 	at club.hd.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:22)
 * 	at club.hd.outofmemory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:22)
 */
