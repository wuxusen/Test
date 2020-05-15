package com.wxs.algorithm.week08.sort;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Sort3 {

    public static void main(String[] args) {

        Sort3 sort3 = new Sort3();
        int[] arr = {6, 3, 2, 8, 17, 12, 7};

        //sort3.mergeSort(arr, 0, arr.length-1);
        sort3.quikSort(arr, 0, arr.length - 1);
        System.out.println(arr);

    }



    private void mergeSort(int[] arr, int left, int right) {

        if(left >= right){
            return;
        }

        int mid = (left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // 需要重新申请一个数组，所以不是原地排序算法
        int[] temp = new int[right - left +1];

        int l = left; // 左边 开始位置
        int r = mid+1; // 右边开始位置
        int k = 0;// 用来记录临时素组的索引

        while (l <= mid && r <= right){
            temp[k++] = arr[l] > arr[r] ? arr[r++]: arr[l++];
        }

        while (l<= mid) temp[k++] = arr[l++];
        while (r <= right) temp[k++] = arr[r++];


        for (int i = 0; i < temp.length; i++) {
           arr[i+left] = temp[i];
        }
    }


    private void quikSort(int[] arr, int left, int right) {

        if(left >= right){
            return;
        }

        int partition = partition(arr,left,right);
        quikSort(arr,left,partition -1);
        quikSort(arr,partition+1,right);


    }

    /**
     *  分区：
     *  随机取一个povit ，让小于arr[povit]的值移动到 左边，大于放在右边
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {

        int povit = right;
        int begin = left;
        int couner = left;

        for (int i = begin; i < povit; i++) {

            if(arr[i] < arr[povit]){
                swap(arr,i,couner);
                couner++;
            }

        }
        swap(arr,couner,povit);
        return couner;
    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
