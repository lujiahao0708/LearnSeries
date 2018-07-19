package com.lujiahao.rxjava1_x.demos.FilterRequest;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lujiahao
 * @date 2018-07-12 下午5:11
 */
public class DistinctWithTimeout<T, U> implements Observable.Operator<T, T> {

    //调度器，建议用主线程
    final Scheduler scheduler;
    //与Distinct中的select含义相同，用于判断两个时间是否重复
    final Func1<? super T, ? extends U> selector;
    final TimeUnit timeUnit;
    final long timeInMilliseconds;
    //被过滤时的回调
    final Action1<T> action1;

    public DistinctWithTimeout(long timeInMilliseconds, TimeUnit timeUnit,
                               Func1<? super T, ? extends U> selector, Scheduler scheduler, Action1<T> duplicateAction) {
        this.timeUnit = timeUnit;
        this.selector = selector;
        this.action1 = duplicateAction;
        this.timeInMilliseconds = timeInMilliseconds;
        this.scheduler = scheduler;
    }

    @Override public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return new Subscriber<T>() {

            /**
             * 本方法仅仅用于并发量不大的请求，比如界面编程中使用。如果是长间隔、大对象下，Map可能会内存爆炸的。
             * 在服务端真正使用的话可以用Redis替换掉上文的Map，比如它的expire属性。
             */
            private Map<U, Long> lastMap = new HashMap<>();

            @Override public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override public void onError(Throwable e) {
                subscriber.onError(e);
            }

            @Override public void onNext(T t) {
                long now = scheduler.now();
                U u = selector.call(t);
                //解开装箱
                long last = lastMap.get(u) == null ? (0) : (lastMap.get(u));
                //如果没有超时
                if (now - last >= timeUnit.toMillis(timeInMilliseconds)) {
                    lastMap.put(u, now);
                    subscriber.onNext(t);
                } else {
                    //调用超时后的Action
                    action1.call(t);
                }
            }
        };
    }
}