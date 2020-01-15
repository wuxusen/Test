package com.wxs.thread.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-12-31
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestThreadLocal {



    final static ThreadLocal<String> LOCAL = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 线程1
        executorService.execute(() -> {
            // 存值
            LOCAL.set(Thread.currentThread().getName());
            // 获取值
            System.out.println(Thread.currentThread().getName() + "-->" +LOCAL.get());
        });
        // 线程2
        executorService.execute(() -> {
            LOCAL.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "-->" +LOCAL.get());
        });
        executorService.shutdown();
    }


}
