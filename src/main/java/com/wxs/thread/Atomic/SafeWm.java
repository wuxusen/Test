package com.wxs.thread.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class SafeWm {
//
//    class WMRange {
//        final int upper;
//        final int lower;
//
//        WMRange(int upper, int lower) {
//            // 省略构造函数实现
//        }
//    }
//
//    final AtomicReference<WMRange> rf = new AtomicReference<>(
//            new WMRange(0, 0)
//    );
//
//    // 设置库存上限
//    void setUpper(int v) {
//        WMRange nr;
//        WMRange or = rf.get();
//        do {
//            // 检查参数合法性
//            if (v < or.lower) {
//                throw new IllegalArgumentException();
//            }
//            nr = new WMRange(v, or.lower);
//
//        } while (!rf.compareAndSet(or, nr));
//    }
}
