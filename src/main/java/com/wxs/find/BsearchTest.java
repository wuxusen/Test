package com.wxs.find;

/**
 * 类描述  ： 二分法
 * 创建人  : 吴绪森
 * 创建时间：2019-08-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class BsearchTest {


    public static void main(String[] args) {

        int[] a = {1, 3, 5, 6, 6, 6, 8, 9};
        int v = 6;


        // int bsearch = bsearch(a, v);
        // int bsearch = bsearch(a, 0, a.length - 1, v);

//        int bsearchFirst = bsearchFirst(a, v);
//
//        int bsearchEnd = bsearchEnd(a, v);
//
//        System.out.println("bsearchFirst >>>>" + bsearchFirst);
//
//        System.out.println("bsearchEnd >>>>" + bsearchEnd);
//
//        int big = bsearchFirstBig(a, 1);
//        System.out.println("big >>>>" + big);


        int[] aa = {5,1,3};


        int i = bsearchC(aa, 1);

        System.out.println(">>>" + i);


    }


    public static int bsearch(int[] a, int v) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == v) {
                return mid;
            } else if (a[mid] > v) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static int bsearch(int[] a, int low, int high, int v) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == v) {
            return mid;
        } else if (a[mid] > v) {
            return bsearch(a, low, mid - 1, v);
        } else {
            return bsearch(a, mid + 1, high, v);
        }

    }


    public static int bsearchFirst(int[] a, int v) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == v) {
                if (mid == 0 || a[mid - 1] != v) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] > v) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int bsearchEnd(int[] a, int v) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == v) {
                if (mid == 0 || a[mid + 1] != v) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] > v) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int bsearchFirstBig(int[] a, int v) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid;
                } else {
                    high = mid - 1;

                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static int bsearchC(int[] nums, int target) {


        if(nums.length == 0){
            return  -1;
        }else if(nums.length ==1){
            return nums[0] == target ? 0:-1;
        }else if(nums[0] == target){
            return 0;
        }else if(nums.length == 2){
            return nums[0] == target ? 0:nums[1]== target ? 1: -1;
        }


        int maxVIndex = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[maxVIndex] < nums[i]) {
                maxVIndex = i;
            }
        }

        int[] aa = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(maxVIndex == 0){

            }

            int i1 = (i + maxVIndex ) % (nums.length);
            aa[i1] = nums[i];
        }

        int low = 0;
        int high = aa.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (aa[mid] == target) {
                int index = (mid - maxVIndex ) <= 0 ? mid - maxVIndex + aa.length : mid - maxVIndex;
                return index;
            } else if (aa[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }


}
