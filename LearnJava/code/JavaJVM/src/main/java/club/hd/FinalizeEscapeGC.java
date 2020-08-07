package club.hd;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        System.out.println("第一次执行===================");
        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低,暂停 0.5s 等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        System.out.println("第二次执行===================");
        // 下面这段代码与上面完全相同,但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低,暂停 0.5s 等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
        // finalize 方法只能被虚拟机执行一次
        // 第一次进行 gc 时 finalize 方法被虚拟机自动执行时将自己 this 赋值给成员变量 SAVE_HOOK,完成了一次自我拯救
        // 第二次进行 gc 时 由于 finalize 方法已经被执行过,因此变量SAVE_HOOK会被 gc 回收掉

        /**
         * 执行结果
         * 第一次执行===================
         * finalize method executed
         * yes, i am still alive :)
         * 第二次执行===================
         * no, i am dead :(
         */
    }
}
