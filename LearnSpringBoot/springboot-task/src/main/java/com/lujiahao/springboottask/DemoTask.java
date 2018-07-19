package com.lujiahao.springboottask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lujiahao
 * @date 2017-12-13 下午9:54
 */
@Component
public class DemoTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000,initialDelay = 1000)
    public void demoTask() {
        System.out.println(dateFormat.format(new Date()) + "测试定时任务执行");
    }

//    @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
//    @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
//    @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
//    @Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
}
