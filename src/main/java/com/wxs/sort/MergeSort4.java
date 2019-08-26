package com.wxs.sort;

/**
 * 类描述  归并排序
 * 创建人  : 吴绪森
 * 创建时间：2019-07-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MergeSort4 {

    public static void main(String[] args) {


        int[] a = {6, 2, 5, 8, 9, 1, 12, 7};
        sort(a,0,a.length -1);

        System.out.println(a);


    }

    public static void sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high) {
            return;
        }
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);

    }


    public static void merge(int[] a, int low, int mid, int high) {
        int[] left = new int[mid - low + 2];
        int[] right = new int[high - mid + 1];

        for (int i = 0; i <= mid - low; i++) {
            left[i] = a[low + i];
        }

        for (int i = 0; i < high - mid ; i++) {
            right[i] = a[mid + i + 1];
        }


        left[left.length -1] = Integer.MAX_VALUE;
        right[right.length-1]= Integer.MAX_VALUE;


        int i = 0;
        int j = 0;
        int k = low;

        while (k <= high){

            if(left[i] <= right[j]){
                a[k++] = left[i++];
            }else {
                a[k++] = right[j++];
            }
        }


    }


}
