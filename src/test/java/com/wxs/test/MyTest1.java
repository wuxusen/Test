package com.wxs.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public void testSort1(){

        int[]  arr = {4,1,7,3,5,12,18,20};
        int[] temp = new int[21];


        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }


        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }

        }

    }
















    @Test
    public void shorts() {

        int[] arr = {8,5,3,3,3,20,17};

        int[] temp = new int[21];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        //顺序打印
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }


    }

    @Test
    public void singleNonDuplicate() {

        int[] nums = {3, 3, 7, 7, 10, 11, 11};

        int a = nums[0];

        for (int i = 1; i < nums.length; i++) {

            a = a ^ nums[i];
        }
        System.out.println(a);
    }


    @Test
    public void test51() {


        int n = 100;

        n >>>= 1;


        System.out.println(n);

    }

    @Test
    public void test6() {


        String str = "aaa_bbb_ccc_ddd";

        int i = str.indexOf("_");

        String substring = str.substring(0, i);


        System.out.println(substring);


    }

    @Test
    public void test5() {


        boolean a = true || false;

        System.out.println(a);


    }

    @Test
    public void test4() {


        Integer a = 128;

        Integer b = 128;


        // 统计 while( a > b){ }


        System.out.println(a == b);


        while (a != b) {


            System.out.println("--------------------");

        }

    }


    @Test
    public void test3() {


        String str = "ssssss,aaaaa,bbbbbbbb,cccccccc,";

        String[] split = str.split(",");

        List<String> list = Lists.newArrayList(split);

        System.out.println(list);


    }


    @Test
    public void test1() {


        List<String> list = new ArrayList<>();

        list.add("aaaa");
        //  list.add("bbbb");


        StringBuilder label = new StringBuilder();

        label.append(list);

        System.out.println(label.toString());


    }


    @Test
    public void testDouble() {

        double d1 = 1;

        double d2 = 1.000000000000000;

        System.out.println(d1 == d2);


        BigDecimal bigDecimal = new BigDecimal(d1);
        BigDecimal bigDecimal1 = new BigDecimal(d2);

        System.out.println(bigDecimal.compareTo(bigDecimal1));


    }


}
