package com.wxs.algorithm.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class reversePairs493 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};

        reversePairs493 reversePairs493 = new reversePairs493();

        int i = reversePairs493.reversePairs(arr);
        System.out.println(i);
    }


    public int reversePairs(int[] nums) {
        return reversePairsHelper(nums, 0, nums.length - 1);
    }

    private int reversePairsHelper(int[] nums, int begin, int end) {

        if (end <= begin) {
            return 0;
        }

        int mid = (end + begin) >> 1;

        int total = reversePairsHelper(nums, begin, mid)+reversePairsHelper(nums, mid + 1, end);


        for (int i = begin,j = mid+1; i <= mid; i++) {

            while (j <= end && nums[i]/2.0 > nums[j])j++;

            total += j -(mid + 1);

        }


        int[] temp = new int[end - begin + 1];

        int i = begin, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            temp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];


        for (int l = 0; l < temp.length; l++) {
            nums[begin + l] = temp[l];
        }

        return total;
    }



}
