package com.lujiahao.learnjava8.completablefuture;

import java.util.concurrent.*;

/**
 * @author lujiahao
 * @date 2019-08-08 16:41
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Boolean result = Boolean.FALSE;
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try
        {
            Future<Boolean> future = threadPool.submit(new MyTimeoutTask());
            result = future.get(5, TimeUnit.SECONDS);
        }
        catch (Exception e)
        {
            result = Boolean.FALSE;
            e.printStackTrace();
        }
        finally
        {
            threadPool.shutdownNow();
        }

        //boolean result = execute(new MyTimeoutTask(), 5);
        System.out.println("result = " + result);
        System.out.println("-- finished. --");
    }

//    /**
//     * 执行一个有时间限制的任务
//     * @param task    待执行的任务
//     * @param seconds 超时时间(单位: 秒)
//     * @return
//     */
//    public static Boolean execute(Callable<Boolean> task, int seconds)
//    {
//        Boolean result = Boolean.FALSE;
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//
//        try
//        {
//            Future<Boolean> future = threadPool.submit(task);
//            result = future.get(seconds, TimeUnit.SECONDS);
//        }
//        catch (Exception e)
//        {
//            result = Boolean.FALSE;
//            e.printStackTrace();
//        }
//        finally
//        {
//            threadPool.shutdownNow();
//        }
//
//        return result;
//    }

}
class MyTimeoutTask implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        System.out.println("mytimetask" + Thread.currentThread().getName());
        for (int i=0; i<10; i++) {
            System.out.println("i = " + i);
            Thread.sleep(1000);
        }
        return true;
    }
}
