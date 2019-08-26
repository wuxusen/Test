package com.wxs.thread.pool;

import java.util.concurrent.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CreatePool {

    public static void main(String[] args) throws InterruptedException {
        //L1、L2 阶段共用的线程池
        ExecutorService es = Executors.
                newFixedThreadPool(2);
        //L1 阶段的闭锁
        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            System.out.println("L1");
            // 执行 L1 阶段任务
            es.execute(() -> {
                //L2 阶段的闭锁
                CountDownLatch l2 = new CountDownLatch(2);
                // 执行 L2 阶段子任务
                for (int j = 0; j < 2; j++) {
                    es.execute(() -> {
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                // 等待 L2 阶段任务执行完
                try {
                    l2.await();
                    System.out.println("L2 两个任务都完成了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }
        // 等着 L1 阶段任务执行完
        l1.await();
        System.out.println("end");


    }
}
