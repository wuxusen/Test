package com.wxs;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        int[] a = {2026,35,2026};
        int target = 4052;
        int[] ints = twoSum(a, target);
        System.out.println(ints);



    }

    final static int indexArrayMax = 2048 * 2 -1;

    static int[] indexArrays = new int[indexArrayMax + 1];

    public static int[] twoSum(int[] nums, int target) {
        Arrays.fill(indexArrays, 0);
        for (int i = 0; i < nums.length; i++) {


            int i1 = target - nums[i];

            int i2 = (target - nums[i]) & indexArrayMax;

            int indexArray = indexArrays[(target - nums[i]) & indexArrayMax];

            if (indexArrays[(target-nums[i])&indexArrayMax] != 0) {
                return new int[] { indexArrays[(target-nums[i])&indexArrayMax] - 1, i };
            }


            int i3 = nums[i] & indexArrayMax;

            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }
}


