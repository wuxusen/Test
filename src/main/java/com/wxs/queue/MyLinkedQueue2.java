package com.wxs.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

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
public class MyLinkedQueue2 {




    public MyLinkedQueue2(Integer maxSize){
        this.maxSize = maxSize;
    }

    private ListNode head = null;
    private ListNode tail = null;

    private Integer size;
    private Integer maxSize;


    public static void main(String[] args) {


       final MyLinkedQueue2 myLinkedQueue = new MyLinkedQueue2(10);


        CountDownLatch count = new CountDownLatch(1000);

        for (Integer i = 0 ;i < 500 ; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    myLinkedQueue.enqueue(new ListNode(1));

                    count.countDown();
                }
            }).start();

        }

        for (Integer i = 0 ;i < 500 ; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myLinkedQueue.dequeue();
                    count.countDown();
                }
            }).start();

        }




        System.out.println("============执行完成=======================");


    }

    public boolean enqueue(ListNode node) {



            if (size >= maxSize) {
                return false;
            }

            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            size++;



        System.out.println(" 入队 size == "+size );

        return true;

    }

    public ListNode dequeue() {


        ListNode node = null;
      
            // 队列已空
            if (head == null) {
               return null;
            }
            node = head;
            head = head.next;
            node.next = null;

            size --;

        System.out.println(" 出队 size == "+size );
        return node;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
