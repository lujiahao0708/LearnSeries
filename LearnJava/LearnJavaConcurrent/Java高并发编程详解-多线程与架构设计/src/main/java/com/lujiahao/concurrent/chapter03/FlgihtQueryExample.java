package com.lujiahao.concurrent.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lujiahao
 * @date 2019-11-24
 */
public class FlgihtQueryExample {

    private static List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("开始时间:" + start);
        List<String> results = search("SH", "BJ");
        System.out.println("=============result=============");
        results.forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("结束时间:" + end);

        System.out.println("时间差:" + (end - start));
    }

    private static List<String> search(String original, String dest) {
        final List<String> result = new ArrayList<>();

        // 查询航班信息线程列表
        List<FlightQueryTask> tasks = flightCompany.stream()
                .map(f -> createSearchTask(f, original, dest))
                .collect(Collectors.toList());

        // 启动线程查询
        tasks.forEach(Thread::start);

        // 分别调用每个线程的join方法,阻塞当前线程
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 当前线程被阻塞,获取每个线程查询结果,加入到result中
        tasks.stream().map(FlightQuery::get).forEach(result::addAll);

        return result;
    }

    private static FlightQueryTask createSearchTask(String flight, String original, String dest) {
        return new FlightQueryTask(flight, original, dest);
    }
}
