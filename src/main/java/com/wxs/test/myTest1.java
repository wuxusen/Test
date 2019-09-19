package com.wxs.test;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-09
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class myTest1 {


    static {
        System.out.println("-------static-------");
    }

    public myTest1(){

        System.out.println("-mytest1");

    }

    {
        System.out.println("-------------");
    }



    public static void main(String[] args) {
        myTest1 myTest1 = new myTest1();

        String aa =  new String("bb");
        myTest1.updateStr(aa);
        System.out.println("outer >>>"+ aa);

    }



    public void updateStr(String str){


        str = new String("cccccccc");
        System.out.println("inner >>"+ str);
    }
}
