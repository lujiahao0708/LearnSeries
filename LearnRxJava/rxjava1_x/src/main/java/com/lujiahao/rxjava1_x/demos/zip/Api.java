package com.lujiahao.rxjava1_x.demos.zip;


/**
 * @author lujiahao
 * @date 2018-07-13 上午11:40
 */
public class Api {
    public static String getNewsList() throws Exception {
        try {
            Thread.sleep(500);
            int i = 1/0;
            return "newsList";
        } catch (InterruptedException e) {
            throw e;
        }

    }

    public static String getBanner() throws Exception {
        try {
            Thread.sleep(500);
            return "banner";
        } catch (InterruptedException e) {
            throw e;
        }
    }
}
