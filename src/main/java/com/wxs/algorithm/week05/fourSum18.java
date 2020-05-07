package com.wxs.algorithm.week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class fourSum18 {


    public static void main(String[] args) {


        fourSum18 fourSum18 = new fourSum18();

        int[] nums = {0,0,0,0};

        List<List<Integer>> lists = fourSum18.fourSum(nums, 0);
        System.out.println(lists);


    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length <4){
            return res;
        }

        if(4 * nums[0] > target){
            return res;
        }

        if(4 * nums[nums.length - 1] < target){
            return res;
        }




        int len = nums.length;


        for (int i = 0; i <= len - 4; i++) {


            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j <= len - 3; j++) {


                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }


                int c = j + 1, d = len - 1;

                while (c < d) {

                    int sum = nums[i] + nums[j] + nums[c] + nums[d];

                    if (sum < target) {
                        c++;
                    } else if (sum > target) {
                        d--;
                    } else {

                        res.add(Arrays.asList(nums[i], nums[j], nums[c], nums[d]));

                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;

    }


}
