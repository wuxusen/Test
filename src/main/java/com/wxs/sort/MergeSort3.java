package com.wxs.sort;

import com.wxs.queue.ListNode;

import java.lang.reflect.Modifier;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MergeSort3 {


    public static void main(String[] args) {
        int[] a = {8, 3, 9, 12, 5, 7, 1};
        sort(a, 0, a.length - 1);

        System.out.println(a);

    }


    public static void sort(int[] a, int low, int high) {

        int mid = (high + low) / 2;

        if (low >= high) return;

        sort(a, low, mid);
        sort(a, mid + 1, high);
        mergeBy(a, low, mid, high);

    }

    public static void mergeSort(int[] a, int low, int mid, int high) {

        int[] tmp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i <= mid) {

            tmp[k++] = a[i++];
        }

        while (j <= high) {
            tmp[k++] = a[j++];
        }


        for (int l = 0; l < tmp.length; l++) {
            a[l + low] = tmp[l];
        }

    }

    public static void mergeBy(int[] a ,int low, int mid ,int high){
        int[] left = new int[mid - low + 2];
        int[] right = new int [high - mid + 1];


        for (int i = low; i <= mid; i++) {
            left[i - low] = a[i];
        }

        for (int i = mid+1; i <= high; i++) {
            right[i - mid-1] = a[i];
        }

        left[left.length - 1] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;

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
