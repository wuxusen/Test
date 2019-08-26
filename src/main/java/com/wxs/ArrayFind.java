package com.wxs;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ArrayFind {


    public static void main(String[] args) {

        char[] a = {4, 2, 3, 5, 6, 9};
        int n = 6;
        char key = 6;

        int i = find(a, n, key);

        System.out.println(i);

    }

    public static int find(char[] a ,int n,char key) {

        if(a == null || n <= 0) {
            return -1;
        }

        if(a[n-1] == key){
            return n-1;
        }

        char tmp = a[n-1];

        a[n-1] = key;


        int i = 0;
        // while 循环比起代码一，少了i<n这个比较操作
        while (a[i] != key) {
            ++i;
        }

        a[n-1] = tmp;
        if (i == n-1) {
            return  -1;
        }else {
            return 1;
        }

    }


}