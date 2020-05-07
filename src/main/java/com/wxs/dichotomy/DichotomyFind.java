package com.wxs.dichotomy;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-01-13
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class DichotomyFind {


    public static void main(String[] args) {


        int[] arr = {3,5,7,9,11,44,55,56,77,99};
        int value = 100;
        Integer first = findFirst(arr, value);

        System.out.println("下标位置为："+ first);

    }

    public static Integer findFirst(int[] arr, int value) {

        if (arr == null) {
            return null;
        }

        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {

            int mid = (low + high)/2;

            if(mid == 0 && arr[mid] != value){
                return -1;
            }
            if(arr[mid] >= value && value > arr[mid - 1] ){
                return mid ;
            }

            if (arr[mid] > value) {
                high = mid - 1;
            }
            if(arr[mid] < value){
                low = mid + 1;
            }
        }


        return -1;

    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }

        }
        return -1;//没有找到返回-1
    }



}
