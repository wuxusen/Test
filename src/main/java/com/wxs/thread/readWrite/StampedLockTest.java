package com.wxs.thread.readWrite;

import java.util.concurrent.locks.StampedLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class StampedLockTest {


    final StampedLock sl = new StampedLock();


    public void read() {


        long stamp = sl.tryOptimisticRead();

        // 获取局部变量

        if (!sl.validate(stamp)) {

            stamp = sl.readLock();

            try {
                // 读入局部变量
            } finally {
                sl.unlockRead(stamp);
            }
        }
    }


    public void write(){
        long l = sl.writeLock();

        try {
            // 数据写入
        }finally {
            sl.unlockWrite(l);
        }



    }
}
