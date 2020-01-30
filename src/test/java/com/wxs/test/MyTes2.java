package com.wxs.test;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019/10/21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MyTes2 {



    @Test
    public void show(){
        Executor executor =   Executors.newFixedThreadPool(1);
        final CyclicBarrier barrier =  new CyclicBarrier(2, ()->{
            executor.execute(()->check());
        });


        for (int i = 0; i < 100; i++) {


            new Thread(()->{


                System.out.println("--------t1 --------------");

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            }).start();
            new Thread(()->{

                System.out.println("--------t2 --------------");

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();


        }








    }



    public void check(){


        System.out.println("check----------------");

    }


}
