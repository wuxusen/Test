package com.wxs.queue;

/**
 * 类描述  ：循环队列
 * 创建人  : 吴绪森
 * 创建时间：2019-07-18
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CircularQueue {

    // 数组:items，数组大小:n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    // 入队
    public boolean enqueue(String item){


        if((tail+1)%n == head){
            //表示已满
            return false;
        }


        items[tail] = item;
        tail = (tail + 1) % n;

        return true;
    }


    public String dequeue(){

        if(head == tail){
            return null;
        }

        String item = items[head];

        head = (head + 1) % n;

        return item;
    }




}
