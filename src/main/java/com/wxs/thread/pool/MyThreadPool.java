package com.wxs.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 类描述  ： 模拟线程池的工作原理
 * 创建人  : 吴绪森
 * 创建时间：2020-08-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MyThreadPool {


    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);

        MyThreadPool myThreadPool = new MyThreadPool(10, workQueue);

        myThreadPool.execute(()-> System.out.println("hello"));


    }


    /**
     * 利用阻塞队列实现 生产者-消费者模式
     */
    BlockingQueue<Runnable> workQueue;

    /**
     * 保存内部工作线程
     */
    List<WorkerThread> threads = new ArrayList<>();


    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;

        for (int i = 0; i < poolSize; i++) {
            WorkerThread work = new WorkerThread();
            work.start();

            threads.add(work);

        }
    }

    void execute(Runnable command){
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class WorkerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }


}
