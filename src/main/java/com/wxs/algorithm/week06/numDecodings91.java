package com.wxs.algorithm.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class numDecodings91 {


    public int numDecodings(String s) {

        int len = s.length();

        int[] dp = new int[len+1];

        dp[len] = 1;

        if(s.charAt(len - 1) != '0'){
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0 ; i--) {
            if(s.charAt(i) == '0'){
                continue;
            }

            int ans1 = dp[i+1];
            int ans2 = 0;

            int ten = (s.charAt(i) - '0') *10;
            int one = s.charAt(i + 1) - '0';
            if(ten+one <= 26){
                ans2 = dp[i+2];
            }

            dp[i] = ans1 + ans2;

        }

        return dp[0];

    }


}
