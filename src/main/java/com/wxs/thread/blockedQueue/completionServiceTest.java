package com.wxs.thread.blockedQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-06
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class completionServiceTest   {


    public static void main(String[] args) throws Exception {

//
//        completionServiceTest a = new completionServiceTest();
////        int show = a.show();
////        System.out.println("show ==>>" + show);
//
//        AtomicReference<Integer> in = a.show2();
//        System.out.println(in.toString());


        ArrayList<String> strings = new ArrayList<>();

        strings.add(null);
        strings.add(null);
        strings.add("b");

        System.out.println(strings.size());


    }


    public AtomicReference<Integer> show2() throws Exception {
        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
// 创建 CompletionService
        CompletionService<Integer> cs = new
                ExecutorCompletionService<>(executor);
// 异步向电商 S1 询价
        cs.submit(() -> geocoderByS1());
// 异步向电商 S2 询价
        cs.submit(() -> geocoderByS2());
// 异步向电商 S3 询价
        cs.submit(() -> geocoderByS3());
// 将询价结果异步保存到数据库
// 并计算最低报价
        AtomicReference<Integer> m = new AtomicReference<>(Integer.MAX_VALUE);

        CountDownLatch c = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Integer r = null;
                try {
                    r = cs.take().get();
                } catch (Exception e) {
                }

                m.set(Integer.min(m.get(), r));
                c.countDown();
            });
        }

        c.await();
        return m;

    }


    public int show() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService<Integer> cs = new ExecutorCompletionService<>(executorService);


        List<Future<Integer>> fu = new ArrayList<>(3);

        fu.add(cs.submit(() -> geocoderByS1()));
        fu.add(cs.submit(() -> geocoderByS2()));
        fu.add(cs.submit(() -> geocoderByS3()));

        Integer r = 0;

        try {

            for (int i = 0; i < 3; i++) {
                r = cs.take().get();

                if (r != null) {
                    break;
                }
            }

        } finally {
            for (Future<Integer> f : fu) {
                f.cancel(true);
            }
        }

        return r;

    }


    public int geocoderByS1() {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 15;
    }

    public int geocoderByS2() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 13;
    }

    public int geocoderByS3() {
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 7;
    }
}
