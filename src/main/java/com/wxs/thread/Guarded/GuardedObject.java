package com.wxs.thread.Guarded;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * 类描述  ：多线程版本的if ，Guarded Suspension ，保护性的暂停
 * 创建人  : 吴绪森
 * 创建时间：2019-08-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class GuardedObject<T> {


    T obj;

    final Lock lock = new ReentrantLock();

    final Condition done = lock.newCondition();

    final int timeOut = 2;

    final static Map<Object, GuardedObject> gos = new ConcurrentHashMap<>();


    public static void main(String[] args) {

        GuardedObject go = GuardedObject.create(1111);

        Object o = go.get(t -> t != null);

    }

    void onMessage(){


        //GuardedObject.fireEvent(111, mess);
    }


    public static <K> GuardedObject create(K key) {

        GuardedObject<Object> go = new GuardedObject<>();

        if (go != null) {
            gos.put(key, go);
        }
        return go;
    }


    public static <K, T> void fireEvent(K key, T obj) {

        GuardedObject remove = gos.remove(key);
        if (remove != null) {

            remove.onChange(obj);
        }

    }


    T get(Predicate<T> p) {

        lock.lock();

        try {

            while (!p.test(obj)) {
                done.await(timeOut, TimeUnit.SECONDS);
            }

        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }

        return obj;

    }


    void onChange(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }

    }


}
