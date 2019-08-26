package com.wxs.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class BlockedQueue<T> {

    final Lock lock = new ReentrantLock();

    // 满
    final Condition notFull = lock.newCondition();

    // 空
    final Condition notEmpty = lock.newCondition();



    void enq(T x){

        lock.lock();



        try {
            // 队列已满
//            while (){
//                notFull.await();
//            }
            // 入队操作
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



    void dep(){
        lock.lock();

        try {

//            while (){
//                notEmpty.await();
//            }

            notFull.signal();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {



    }


}
