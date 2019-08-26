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

public class HeapSort2 {


    public static void main(String[] args) {


        int[] aa = {22, 10, 9, 4, 11, 66,-100,15,55,-23,16};

        HeapSort2.sort(aa);

        System.out.println(aa);


    }

    private static void sort(int[] a) {

        // 堆化，自上而下
        HeapSort2.buildHeap(a);

        int k = a.length - 1;
        while (k >= 0){
            HeapSort2.swap(a,0,k);
            k--;
            HeapSort2.heapily(a,0,k);
        }



    }

    private static void heapily(int[] a, int i, int k) {

        while (true){

            int tmp = i;

            if(i * 2 + 1 <= k && a[i] < a[i * 2 + 1] ){
                tmp = i * 2 + 1;
            }
            if(i * 2 + 2 <= k && a[tmp] < a[i * 2 + 2] ){
                tmp = i * 2 + 2;
            }
            if(i == tmp){
                break;
            }
            swap(a,tmp,i);
            i = tmp;
        }



    }

    private static void buildHeap(int[] a) {

        for (int i = a.length/2 -1; i >= 0; i--) {

            heapily(a,i,a.length -1 );
        }

    }

    private static void swap(int[] a, int i, int k) {
        int tmp = a[i];
        a[i] = a[k];
        a[k] = tmp;
    }


}
