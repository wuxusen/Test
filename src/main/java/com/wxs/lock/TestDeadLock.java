package com.wxs.lock;

import com.oracle.tools.packager.Log;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestDeadLock {


    public static void main(String[] args) throws Exception {


        Object o1 = new Object();
        Object o2 = new Object();


        new Thread(() -> {

            System.out.println("开始执行 >>>>aaaaaaaaa");
            synchronized (o1) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {

                    Log.info("开始执行a >>>>aaaaaaaaa");

                }
            }

        }).start();



        new Thread(() -> {

            System.out.println("开始执行 >>>>bbbbbbb");
            synchronized (o2) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {

                    Log.info("开始执行a >>>>bbbbbb");

                }
            }

        }).start();


    }
}
