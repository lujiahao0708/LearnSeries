package com.lujiahao.rxjava1_x.demos.CacheDemo;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

import java.util.Map;

/**
 * 取数据先检查缓存的场景
 * 取数据，首先检查内存是否有缓存, 然后检查文件缓存中是否有, 最后才从网络中取。
 * 前面任何一个条件满足，就不会执行后面的
 *
 * @author lujiahao
 * @date 2018-07-12 下午6:37
 */
public class CacheDemo {
    public static void main(String[] args) {
        Map<String, Object> memoryCache = Maps.newHashMap();
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "次调用:" + fetchData(memoryCache));
        }
    }

    public static Map<String, Object> fetchData(Map<String, Object> memoryCache) {
        final Observable<String> memory = Observable.create(subscriber -> {
            if (!memoryCache.isEmpty()) {
                subscriber.onNext("cacheStr");
            } else {
                subscriber.onCompleted();
            }
        });
        Observable<String> disk = Observable.create(subscriber -> {
            String cachePref = "diskCacheStr";
            if (StringUtils.isNoneBlank(cachePref)) {
                subscriber.onNext(cachePref);
            } else {
                subscriber.onCompleted();
            }
        });

        Observable<String> network = Observable.just("network");

        //主要就是靠concat operator来实现
        // 可以随时变更获取信息的方式 eg:只选择缓存和网络
        Observable.concat(memory, disk, network)
                .first()
                .subscribe(s -> {
                    memoryCache.put("key", s);
                });

        return memoryCache;
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
