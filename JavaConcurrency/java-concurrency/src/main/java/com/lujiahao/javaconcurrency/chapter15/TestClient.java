package com.lujiahao.javaconcurrency.chapter15;

import java.util.concurrent.TimeUnit;

public class TestClient {
    public static void main(String[] args) {
        Observable observable = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finish done");
            return null;
        });
        observable.start();

        System.out.println("====================");

        final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>(){
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("The result is " + result);
            }
        };
        Observable observable1 = new ObservableThread<>(lifecycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" finish done");
            return "Hello observer";
        });
        observable1.start();
    }
}
