package com.wxs.algorithm.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class findMin153 {


    public static void main(String[] args) {
        findMin153 findMin153 = new findMin153();

        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin153.findMin(nums);

        System.out.println(min);
    }

    public int findMin(int[] nums) {


        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1,mid = 0;

        while (left < right) {

            mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }

        return nums[left];

    }
}
