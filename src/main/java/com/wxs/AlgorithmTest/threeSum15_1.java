package com.wxs.AlgorithmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-03
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class threeSum15_1 {

    /**
     * 三数之合，利用双指针，把数组排序时间复杂度为O(nlogn) ,然后利用双指针，时间复杂度为O(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (sum < 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[--r]) ;
                    while (l < r && nums[l] == nums[++l]) ;

                }
            }
        }
        return res;

    }
}
