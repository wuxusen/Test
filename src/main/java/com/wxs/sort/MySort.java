package com.wxs.sort;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MySort {


    public static void main(String[] args) {


        int[] a = {6, 4, 5, 7, 3};
        insertionSort(a);

        System.out.println(a);


    }

    public static int[] bubbleSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;

                }
            }
            if (!flag) break;
        }

        return a;
    }


    public static void insertionSort(int[] a, int n) {

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }


    public static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }

    }


    public static int[] insertionSort(int[] a) {

        if (a == null || a.length == 0) {
            return a;
        }

        for (int i = 0; i < a.length -1; i++) {
            int curr = a[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && curr < a[preIndex]){

                a[preIndex + 1] = a[preIndex];

                preIndex -- ;

            }

            a[preIndex + 1] = curr;

        }




        return a;


    }


}
