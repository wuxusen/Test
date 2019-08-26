package com.wxs.sort;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-31
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class QuickSort2 {


    public static void main(String[] args) {
        int[] a = {6,2,5,9,4,7};

        sort(a,0,a.length -1);

        System.out.println(a);

    }


    public static void sort(int[] a,int low ,int high){

        if(low >= high){
            return;
        }

        int random = parition(a,low,high);

        sort(a,low,random -1);
        sort(a,random+1,high);

    }

    public static int parition(int[] a,int low,int high){

        int highV = a[high];
        int j = low;
        for (int i = low; i < high; i++) {
            if(a[i] < highV){
                if(i == j){
                  j++;
                }else {

                    int tmp = a[i];
                    a[i] = a[j];
                    a[j++] = tmp;
                }
            }

        }

        int tmp = a[high];
        a[high] = a[j];
        a[j] = tmp;
        return j;


    }
}
