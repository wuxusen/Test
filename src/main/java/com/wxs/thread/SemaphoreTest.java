package com.wxs.thread;

import com.wxs.queue.ListNode;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class SemaphoreTest {


    public static void main(String[] args) {

        ListNode node = new ListNode(1);

        ListNode prev = node;

        for (int i = 0; i < 2019; i++) {

            prev.next = new ListNode(i+2);

            prev = prev.next;
        }

        prev.next = node;

        System.out.println(node);


        node = node.next.next.next;

        ListNode curr = node;



        while (curr != null && curr.next != null ){

            if(curr.val > curr.next.next.next.val){


            }


            curr.next  =  curr.next.next.next.next;

            if(curr.next == curr){
                break;
            }
            curr = curr.next;



        }

        System.out.println(node.val);


    }
    static final Semaphore sp = new Semaphore(1);

    static int count = 0;

    static void addOne() throws InterruptedException {
        sp.acquire();

        try {
            count += 1;
        } finally {
            sp.release();
        }


    }

}


class ObjPool<T, R> {


    public static void main(String[] args) {
        // 创建对象池
        ObjPool<Long, String> pool = new ObjPool<Long, String>(10, 2L);
        // 通过对象池获取 t，之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }

    final List<T> pool;

    // 用信号量实现限流器
    final Semaphore sem;

    // 构造函数
    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    // 利用对象池的对象，调用 func
    R exec(Function<T, R> func) {

        T t = null;

        try {
            sem.acquire();
            t = pool.remove(0);
            return func.apply(t);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.add(t);
            sem.release();
        }
        return null;
    }





}

