package club.hd.thread;

/**
 * 多线程demo
 * @author lujiahao
 * @date 2019/11/11
 */
public class ThreadDemo implements Runnable{
    private int count = 10;

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "Thread" + i).start();
        }
    }

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count=" + count);
    }
}
