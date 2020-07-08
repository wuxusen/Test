package com.wxs.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestMap {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch  countDownLatch = new CountDownLatch(3);

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();

        countDownLatch.await();


        Semaphore semaphore = new Semaphore(10);

        semaphore.acquire();
        semaphore.release();


        CyclicBarrier c = new CyclicBarrier(3);

        try {
            int await = c.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }


}
