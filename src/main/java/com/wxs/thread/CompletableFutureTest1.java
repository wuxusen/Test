package com.wxs.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CompletableFutureTest1 {


    public static void main(String[] args) throws Exception {
        CompletableFutureTest1 completableFutureTest = new CompletableFutureTest1();

        completableFutureTest.show1();

        Thread.sleep(1000L);
    }

    public void show() {

        String name = Thread.currentThread().getName();
        System.out.println(name);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {

            System.out.println("completableFuture ------ runasync");


        });

    }


    public void show1()throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {

            sleep(11, TimeUnit.SECONDS);
            return "aaaa";

        },executorService);

        String s = supplyAsync.get();
        System.out.println(s);

    }


    void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }


}
