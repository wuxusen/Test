package com.wxs.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-06
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ForkJoinMergeSort {


    public static void main(String[] args) {



        int[] a ={15,2,77,8,3};

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        MergeSortF mergeSortF = new MergeSortF(a);

        forkJoinPool.invoke(mergeSortF);


    }




}

class MergeSortF extends RecursiveTask<int[]> {

    int[] a;


    public MergeSortF(int[] a) {
        this.a = a;

    }


    @Override
    protected int[] compute() {

        if (a.length < 2) return a;
        int mid = a.length / 2;
        MergeSortF left = new MergeSortF(Arrays.copyOfRange(a, 0, mid));
        left.fork();
        MergeSortF right = new MergeSortF(Arrays.copyOfRange(a, mid, a.length));
        return merge(right.compute(), left.join());
    }


    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, m = 0, j = 0; m < result.length; m++) {
            if (i >= left.length) {
                result[m] = right[j++];
            } else if (j >= right.length) {
                result[m] = left[i++];
            } else if (left[i] > right[j]) {
                result[m] = right[j++];
            } else result[m] = left[i++];
        }
        return result;
    }


}