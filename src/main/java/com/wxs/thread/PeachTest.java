package com.wxs.thread;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class PeachTest {


    public static void main(String[] args) {

        int[] a = {3, 5, 16,44, 55,66,77,120,};
        int[] b = {4, 5, 33, 44, 48,150};


        int[] merge = merge(a, b);

        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i] + " ");

        }

    }


    public static int[] merge(int[] a, int[] b) {

        if (a == null || a.length == 0) {
            return b;
        }
        if (b == null || b.length == 0) {
            return a;
        }

        int[] aa = new int[a.length + b.length];


        int i = 0;
        int j = 0;
        int flag = 0;

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                aa[flag++] = a[i++];

            } else {
                aa[flag++] = b[j++];
            }
        }

        while (i < a.length){
            aa[flag++] = a[i++];

        }


        while (j < b.length) {
            aa[flag++] = b[j++];

        }


        return aa;


    }


}

class Peach {

    private int peachNum = 100;

    private int tmp = 0;


    public synchronized void partion() {

        tmp = peachNum;

        if (peachNum != 0) {

            if (peachNum % 2 == 0) {

                peachNum = peachNum / 2;

            } else {
                peachNum = peachNum - (peachNum / 2 + 1);
            }


        }


    }


}
