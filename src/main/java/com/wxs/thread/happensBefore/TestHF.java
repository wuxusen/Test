package com.wxs.thread.happensBefore;

import lombok.extern.slf4j.Slf4j;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Slf4j
public class TestHF {


    /**
     * 多线程  a线程调用用writer，b线程调用reader，当reader方法中v==true时，此时x会是多少呢 ？
     *
     * 1.5 以后对volatile语义增强 也就是happens-before 原则 x = 42
     *
     * 前面一个操作对后续操作是可见的
     *
     * 1、程序的顺序性规则
     *    变量x happen-before 变量v ,所以v能感知到x的变化(废话）
     * 2、volatile 变量规则
     *    一个变量的写操作 happens-before 这个变量的读操作， 所以，当线程b去读操作时，可以看到v的最新值，也就是禁用缓存
     * 3、传递性
     *      A happens-befor b ,b happens-before c ,那么 a happens-before c 。所以，在b线程中能看到变量x的最新值42
     *
     * 4、管程中锁的规则
     *     一个锁的解锁happens-before一个锁的加锁
     *
     * 5、线程start规则，在线程A调用线程B的start方法，那么start操作happens-before线程b中的任意操作
     *    意思就是，在start前设置的变量，在线程b可见
     * 6、线程join规则
     *    意思是，a线程启动b线程后， 在a中join，等待b线程结束。所有变量可见
     *    线程b中的任意操作 happens-before 线程a join 的返回。
     *
     * 7、final ，不可变，可以任意优化。
     *
     */



    int x = 0;

    public static void main(String[] args) {

        TestHF testHF = new TestHF();

        for (int i = 0; i < 100; i++) {
            Thread t2 = new Thread(()->testHF.reader());
            t2.start();

        }


        System.out.println(testHF.x);
    }


    public void reader() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x=x+1;
    }


}
