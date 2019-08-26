package com.wxs.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-18
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Slf4j
public class MyLinkedQueue {


    final Lock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();

    Condition notEmpty = lock.newCondition();

    public MyLinkedQueue(int maxSize){
        this.maxSize = maxSize;
    }

    private ListNode head = null;
    private ListNode tail = null;

    private int size;
    private int maxSize;


    public static void main(String[] args) throws InterruptedException {


       final MyLinkedQueue myLinkedQueue = new MyLinkedQueue(10);


        CountDownLatch count = new CountDownLatch(1000);

        for (int i = 0 ;i < 500 ; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    myLinkedQueue.enqueue(new ListNode(1));

                    count.countDown();
                }
            }).start();

        }

        for (int i = 0 ;i < 500 ; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myLinkedQueue.dequeue();
                    count.countDown();
                }
            }).start();

        }


        count.await();

        System.out.println("============执行完成=======================");


    }

    public boolean enqueue(ListNode node) {

        lock.lock();

        try {
            while (size >= maxSize) {
                notFull.await();
            }

            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            size++;
            notEmpty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        System.out.println(" 入队 size == "+size );

        return true;

    }

    public ListNode dequeue() {

        lock.lock();
        ListNode node = null;
        try {
            // 队列已空
            while (head == null) {
                notEmpty.await();
            }
            node = head;
            head = head.next;
            node.next = null;

            size --;
            notFull.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
        System.out.println(" 出队 size == "+size );
        return node;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
