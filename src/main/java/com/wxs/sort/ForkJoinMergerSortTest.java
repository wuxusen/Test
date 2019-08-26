package com.wxs.sort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-07
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ForkJoinMergerSortTest {


    public static void main(String[] args) {

        int[] a ={15,2,77,8,3};

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        FjMergeSort mergeSortF = new FjMergeSort(a,0,a.length - 1);

        forkJoinPool.invoke(mergeSortF);

        System.out.println(a);
    }

}


class FjMergeSort extends RecursiveAction {

    private int[] a;
    private int low;
    private int high;


    public FjMergeSort(int[]a,int low ,int high){
        this.a = a;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {

        int mid = (low + high) / 2;
        if (low >= high) {
            return;
        }
        FjMergeSort a = new FjMergeSort(this.a, low, mid);
        FjMergeSort b = new FjMergeSort(this.a, mid + 1, high);

        invokeAll(a,b);
        a.join();
        b.join();

        merge(this.a, low, mid, high);
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