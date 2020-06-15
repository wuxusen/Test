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

public class threeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {

            if (nums[k] > 0) break;

            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;

            while (i < j) {

                int sum = nums[k] + nums[i] + nums[j];

                if (sum > 0) {

                    while (i < j && nums[j] == nums[--j]) ;

                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;

                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[j] == nums[--j]) ;
                    while (i < j && nums[i] == nums[++i]) ;

                }
            }
        }
        return res;
    }
}
