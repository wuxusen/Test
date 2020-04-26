package com.wxs.bitOperation;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-09
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */


public class TestBit {


    public static void main(String[] args) {


        int a = 11;
        int b = 16;


        int flag1 = a & 1;
        int flag2 = b & 1;

        // 判断奇数偶数，
        System.out.println(flag1+ "----------"+ flag2);

        int c = 12367845;

        System.out.println(c >>4&1);

    }


}
