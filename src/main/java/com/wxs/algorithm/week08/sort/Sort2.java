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

public class Sort2 {

    public static void main(String[] args) {

        Sort2 sort2 = new Sort2();
        int[] arr = {6, 3, 2, 8, 17, 12, 7};

        // sort2.mergeSort(arr, 0, arr.length-1);
        sort2.quikSort(arr, 0, arr.length - 1);
        System.out.println(arr);

    }


    private void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int l = left, r = mid + 1, k = 0;

        while (l <= mid && r <= right) {
            temp[k++] = arr[l] > arr[r] ? arr[r++] : arr[l++];
        }


        while (l <= mid) temp[k++] = arr[l++];
        while (r <= right) temp[k++] = arr[r++];


        for (int i = 0; i < temp.length; i++) {

            arr[left + i] = temp[i];
        }

    }

    private void quikSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);
        quikSort(arr, left, pivot - 1);
        quikSort(arr, pivot + 1, right);

    }


    private int partition(int[] arr, int left, int right) {

        int pivot = right;
        int counter = left;

        for (int i = left; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, counter);
                counter++;
            }
        }
        swap(arr, pivot, counter);
        return counter;

    }

    private void swap(int[] arr, int i, int counter) {
        int temp = arr[i];
        arr[i] = arr[counter];
        arr[counter] = temp;
    }


}
