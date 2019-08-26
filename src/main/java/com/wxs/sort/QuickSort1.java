package com.wxs.sort;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class QuickSort1 {




    public static void main(String[] args) {
        int[] a = {3,6,2,1,7,9};
        quick(a, 0, a.length - 1);

        System.out.println(a);

    }


    public static void quick(int[] a,int low,int high){

        if(low > high){
            return;
        }

        int random = partion(a,low,high);

        quick(a,low,random -1);
        quick(a,random+1,high);

    }


    public static int partion(int[] a,int low,int high){

        int maxV = a[high];

        int j = low;

        for (int i = low; i < high; i++) {

            if(a[i] < maxV){

                if(i == j){
                    j ++;
                }else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j++] = tmp;
                }

            }

        }
        int tmp = a[j];
        a[j] = a[high];
        a[high] = tmp;
        return j;

    }
}
