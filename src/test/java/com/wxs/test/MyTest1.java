package com.wxs.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */


public class MyTest1 {


    @Test
    public void test1(){


        BigDecimal yss = new BigDecimal("Yss");




    }







    @Test
    public void testDouble(){

        double d1 = 1;

        double d2 = 1.0;

        System.out.println(d1 == d2);


        BigDecimal bigDecimal = new BigDecimal(d1);
        BigDecimal bigDecimal1 = new BigDecimal(d2);

        System.out.println(bigDecimal.compareTo(bigDecimal1));


    }
}
