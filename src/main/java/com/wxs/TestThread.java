package com.wxs;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-06-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestThread {


    public static void main(String[] args) {


        for (int i = 0 ; i < 10000 ; i ++){
            VolatileExample volatileExample = new VolatileExample();


            Thread t =  new Thread(()->{



            });


            Thread t1 =  new Thread(()->{
                volatileExample.reader();
            });


            t.start();
            t1.start();
        }



    }



}


// 以下代码来源于【参考 1】
class VolatileExample {
    String x = "0";
    boolean v = false;
    public void writer() {
        x = "42";
        v = true;
    }
    public void reader() {
        if (v == true) {
            System.out.println(x);
            System.out.println("-------------------------");
        }
    }
}
