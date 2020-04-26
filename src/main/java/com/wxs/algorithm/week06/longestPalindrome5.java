package com.wxs.algorithm.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class longestPalindrome5 {


    public static void main(String[] args) {
        longestPalindrome5 longestPalindrome5 = new longestPalindrome5();

        String babad = longestPalindrome5.longestPalindrome("babad");

        System.out.println(babad);


    }


    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int strLen = s.length();

        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {

            left = i - 1;
            right = i + 1;

            while (left > 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }

            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }


            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {


                len+=2;
                right++;
                left--;

            }

            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }

            len = 1;

        }

        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }




    public String longestPalindrome2(String s) {

        if(s == null || s.length() < 2){
            return s;
        }


        int strLen = s.length();

        int maxStart = 0;

        int maxEnd = 0;

        int maxLen = 1;


        boolean[][] dp = new boolean[strLen][strLen];


        for (int i = 0; i < strLen; i++) {

            for (int j = i; j >= 0; j--) {

                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])){

                    dp[i][j] = true;

                    if(i - j + 1 > maxLen){

                        maxStart = j;
                        maxEnd = i;
                        maxLen = i - j + 1;

                    }


                }
            }

        }

        return s.substring(maxStart,maxEnd + 1);
    }












}
