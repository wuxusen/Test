package com.wxs.heap;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class HeapSort {


    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort(6);

        int[] aa = {0, 22, 6, 9, 4, 11, 66};

//        for (int i = 0; i < aa.length; i++) {
//            heapSort.insert(aa[i]);
//        }
//        heapSort.removeMax();
//        heapSort.removeMax();


        heapSort.sort(aa, aa.length - 1);


        System.out.println(aa);


    }

    private int[] a; // 数组，从下标1开始存储数据
    private int n; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数


    public HeapSort(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap()函数作用:交换下标为i和i/2的两个元素
            i = i / 2;
        }
    }

    private void swap(int[] a, int c, int p) {
        int temp = a[c];
        a[c] = a[p];
        a[p] = temp;
    }


    public void removeMax() {
        if (count == 0)
            return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


    private void buildHeap(int[] a, int n) {
        for (int i = n / 2 ; i >= 1; --i) {
            heapify(a, n, i);
        }
    }


    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }



    private void heapify1(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && a[maxPos] < a[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }


}
