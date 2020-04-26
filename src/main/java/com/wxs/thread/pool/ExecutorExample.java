package com.wxs.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {


    public static void main(String[] args) {




        ExecutorService threadPool =
                new ThreadPoolExecutor(1 /*core*/, 50 /*max*/, 60 /*timeout*/,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(/* unlimited queue */));
    }

}