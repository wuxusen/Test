package com.wxs.algorithm1.week03;

/**
 * 类描述  ：一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 创建人  : 吴绪森
 * 创建时间：2020-03-24
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class massage1716 {




    public static void main(String[] args) {
        massage1716 solution = new massage1716();
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution.massage1(nums);
        System.out.println(res);
    }

    public int massage(int[] nums) {

        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return nums[0];
        }


        int[][] dp  = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 0; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];

        }

        return Math.max(dp[length - 1][0],dp[length - 1][1]);

    }


    public int massage1(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

}
