package com.wxs.thread;

import java.text.SimpleDateFormat;

public class Tool {
    public static void main(String[] args) throws Exception {
        System.out.println(SafeDateFormat.get());
        System.out.println(Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(SafeDateFormat.get());
            }
        }).start();

    }

    static class SafeDateFormat {
        static final ThreadLocal<SimpleDateFormat> sdf =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        static SimpleDateFormat get() {
            return sdf.get();
        }
    }
}