package com.wxs.thread.readWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-01
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Cache<K,V> {


    final Map<K,V> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // 读锁
    Lock readLock = lock.readLock();
    // 写锁
    Lock writeLock =  lock.writeLock();

    V get(K k){
        V v = null;

        readLock.lock();
        try {
            v = map.get(k);
        }finally {
            readLock.unlock();
        }

        if(v != null){
            return v;
        }

        writeLock.lock();
        try {

            v = map.get(k);

            if(v == null){
                // 查询数据库
                //v =
                // 放入缓存
                map.put(k,v);

            }


        }finally {
            writeLock.unlock();
        }

        return v;


    }

    V put(K k, V v){
        writeLock.lock();

        try {
           return map.put(k,v);
        }finally {
            writeLock.unlock();
        }
    }



}
