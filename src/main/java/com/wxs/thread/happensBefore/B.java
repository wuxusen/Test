package com.wxs.thread.happensBefore;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class B extends  A {


    public B(){

       super();

        Thread s;
        Thread.sleep(100,1);

        Thread.currentThread().sleep(100);
        int b = 5;
    }
}
