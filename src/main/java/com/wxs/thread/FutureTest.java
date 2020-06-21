package com.wxs.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/31
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class FutureTest {


    public  void main(String[] args) throws ExecutionException, InterruptedException {



        FutureTask<String> ft2 = new FutureTask<>(new T2task());


        FutureTask<String> ft1 = new FutureTask<>(new T1task(ft2));


        new Thread(ft1).start();
        new Thread(ft2).start();

        System.out.println(ft1.get());// 等待futureTask1 执行完成


    }


    class  T1task implements Callable<String>{

        FutureTask<String> ft2;

        public  T1task(FutureTask<String> ft2){
            this.ft2 = ft2;
        }


        @Override
        public String call() throws Exception {

            ft2.get();// 等待ft2执行完成

            return null;
        }
    }


    class  T2task implements Callable<String>{
        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
