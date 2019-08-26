package com.wxs.queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ArrayQueue {

    public static void main(String[] args) {


        int i = 0 ;

        int s  = i ++ ;
        int b =  ++ i;


        System.out.println("s=="+ s );
        System.out.println("b=="+ b );

    }


    // 数组:items，数组大小:n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }



    // 入队
    public boolean enqueue(String item){

        if(tail == n){
            //队列已满
            if(head == 0){
                return false;
            }

            for(int i = head; i < tail; i ++ ){

                items[i-head] = items[i];

            }

            tail = tail - head;
            head = 0;
        }

        this.items[tail] = item;
        tail ++ ;
        return true;
    }


    public String dequeue(){

        if(head == tail){
            return null;
        }

        return items[head++];
    }




}