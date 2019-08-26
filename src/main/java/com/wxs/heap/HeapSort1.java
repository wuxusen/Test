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

public class HeapSort1 {


    public static void main(String[] args) {



        int[] aa = {22, 6, 9, 4, 11, 66};

        HeapSort1.sort(aa);

        System.out.println(aa);


    }



    private static void swap(int[] a, int c, int p) {
        int temp = a[c];
        a[c] = a[p];
        a[p] = temp;
    }




    private static void heapify(int[] a, int n, int i) { // 自上往下堆化
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


    public static void build1(int[] a , int i, int n){

        while (true){

            int tmp = i;

            if(i * 2 + 2 <= n && a[i] < a[i * 2 + 2]){
                tmp = i * 2 + 2;
            }
            if(i * 2 + 1 <= n && a[tmp] < a[i * 2 + 1]){
                tmp = i * 2 + 1;
            }

            if(i == tmp){
                break;
            }
            swap(a,i,tmp);
            i = tmp;

        }



    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2 ; i >= 1; --i) {
            heapify(a, n, i);
        }
    }



    public static void buildHeap1(int[] a,int n){

        for (int i = (n -1 ) >> 1; i >= 0; i--) {
            build1(a,i,n);
        }

    }


    /**
     *   i 父节点 n 最大下标
     * @param a
     * @param i
     * @param n
     */





    public static void sort(int[] a){

        buildHeap1(a,a.length - 1);

        int k = a.length -1 ;

        while (k > 0){
            swap(a,0,k);
            --k;
            build1(a,0,k);
        }


    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n); // 大顶堆 堆化
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }






}
