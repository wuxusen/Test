package com.wxs.reference;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-01-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestInteger {


    public static void main(String[] args) {

        Integer a = 555555;

        Integer b = new Integer(666666);

        TestInteger testInteger = new TestInteger();

        testInteger.add(a);
        testInteger.add(b);

        System.out.println(a);
        System.out.println(b);


    }

    private void add(Integer a) {
        a = a + 10;
    }


}
