package com.wxs.thread.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocalLeak {
    final static ThreadLocal<String> LOCAL = new ThreadLocal();
    public static void main(String[] args) {
      //  testUseThread();
        testUseThreadPool();
    }

    /**
     * 使用线程
     */
    private static void testUseThread() {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    LOCAL.set("2222222222")
            ).start();
        }
    }

    /**
     * 使用线程池
     */
    private static void testUseThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() ->
                    LOCAL.set("ssss")
            );
        }
        executorService.shutdown();
    }
}