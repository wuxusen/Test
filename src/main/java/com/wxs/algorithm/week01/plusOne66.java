package com.wxs.algorithm.week01;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class plusOne66 {


    public static void main(String[] args) {

        int[] arry = {1, 8, 9, 9};

       plusOne(arry);

    }


    public static int[] plusOne(int[] digits) {

        for (int i = digits.length -1; i >= 0; i--) {
            digits[i] ++ ;
            digits[i] = digits[i] % 10 ;
            if(digits[i] != 0){
                return digits;
            }
        }

        digits = new int[digits.length + 1];

        digits[0] = 1;
        return digits;


    }




    // 实现计算器，必须使用栈，栈的特性决定了，必须要从后到前遍历
    public static int[] plusOne2(int[] digits) {


        for (int i =  digits.length - 1; i >= 0; i--) {
            digits[i]++;

            digits[i]=  digits[i] % 10;

           if(digits[i] != 0){
               return digits;
           }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }




}
