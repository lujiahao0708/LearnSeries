package OutOfMemory;

/**
 * 虚拟机栈和本地方法栈溢出
 * VM Args: -Xss128k
 *
 * The stack size specified is too small, Specify at least 160k
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 *
 * Process finished with exit code 1
 *
 * 设置128k,启动会报上面的问题
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
