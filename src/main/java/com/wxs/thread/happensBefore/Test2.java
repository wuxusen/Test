package com.wxs.thread.happensBefore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Test2 {
    static int count = 0;
    static CountDownLatch cdl = new CountDownLatch(1000);

    /**
     * 微信公众号：Java面经
     */

    public static void main(String[] args) throws Exception {


        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        lock.lock();
        condition.await();
        condition.signalAll();
        lock.unlock();


        CountRunnable countRunnable = new CountRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(countRunnable).start();
        }

        cdl.await();
        System.out.println(count);
    }


    static class CountRunnable implements Runnable {

        private void count() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        @Override
        public void run() {
            count();
            cdl.countDown();
        }

    }
}
