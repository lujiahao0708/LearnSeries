package com.lujiahao.sentinel.base.controller;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class AsyncController {

    @GetMapping("/async")
    public void async() {
        AsyncEntry asyncEntry = null;
        try {
            asyncEntry = SphU.asyncEntry("async");
            asyncMethod();
        } catch (BlockException e) {
            e.printStackTrace();
            System.out.println("被限流或者降级的处理");
        } finally {
            if (asyncEntry != null) {
                asyncEntry.close();
            }
        }
    }

    public void asyncMethod() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread run");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Thread end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
