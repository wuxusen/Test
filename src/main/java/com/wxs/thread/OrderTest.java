package com.wxs.thread;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class OrderTest<P, D> {


//    // 订单队列
//    Vector<P> pos;
//    // 派送单队列
//    Vector<D> dos;
//    // 执行回调的线程池
//    Executor executor =
//            Executors.newFixedThreadPool(1);
//
//    final CyclicBarrier barrier =
//            new CyclicBarrier(2, () -> {
//                executor.execute(() -> check());
//            });
//
//
//    CyclicBarrier cyc =  new CyclicBarrier(2,()->{
//        executor.execute(() -> check());
//    });
//
//    void check() {
//        P p = pos.remove(0);
//        D d = dos.remove(0);
//        // 执行对账操作
//        diff = check(p, d);
//        // 差异写入差异库
//        save(diff);
//    }
//
//    void checkAll() {
//        // 循环查询订单库
//        Thread T1 = new Thread(() -> {
//            while (存在未对账订单) {
//                // 查询订单库
//                pos.add(getPOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T1.start();
//        // 循环查询运单库
//        Thread T2 = new Thread(() -> {
//            while (存在未对账订单) {
//                // 查询运单库
//                dos.add(getDOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T2.start();
//    }


}
