package com.wxs.algorithm.week08;


/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class findKthLargest215 {


    public static void main(String[] args) {

        findKthLargest215 findKthLargest215 = new findKthLargest215();

        int[] arr = {6, 3, 2, 8, 17, 12, 7};


        int kthLargest = findKthLargest215.findKthLargest(arr, 3);

        System.out.println(kthLargest);

    }


    public int findKthLargest(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }

        int target = nums.length - k;

        int left = 0, right = nums.length - 1;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {

                left = left + 1;

            } else {
                right = right - 1;
            }


        }

    }

    private int partition(int[] nums, int left, int right) {

        int povit = right;
        int counter = left;

        for (int i = left; i <= right; i++) {

            if (nums[i] < nums[povit]) {
                swap(nums, i, counter);
                counter++;

            }

        }
        swap(nums, povit, counter);
        return counter;
    }

    private void swap(int[] nums, int i, int counter) {
        int temp = nums[i];
        nums[i] = nums[counter];
        nums[counter] = temp;
    }

}
