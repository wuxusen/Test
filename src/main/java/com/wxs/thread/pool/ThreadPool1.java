package com.wxs.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ThreadPool1 {


    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.submit(() -> {
            try {
                String qq=pool.submit(()->"QQ").get();
                System.out.println(qq);
            } catch (Exception e) {
            }
        });


        String qq=pool.submit(()->"QQ").get();
        System.out.println(qq);

    }
}
