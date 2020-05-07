package com.wxs.algorithm.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class countSubstrings647 {


    public static void main(String[] args) {

        String s = "fdsklf";

        countSubstrings647 countSubstrings647 = new countSubstrings647();
        int i = countSubstrings647.countSubstrings2(s);
        System.out.println(i);

    }


    public int countSubstrings(String s) {

        char[] chars = s.toCharArray();
        int res = 0;


        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j + i - 1 < s.length(); j++) {

                if (isPalindrome(chars, j, j + i - 1)) {
                    res++;
                }

            }


        }

        return res + s.length();

    }

    private boolean isPalindrome(char[] chars, int start, int end) {

        for (int i = start, j = end; j > i; i++, j--) {

            if (chars[i] != chars[j]) {
                return false;
            }

        }
        return true;
    }


    public int countSubstrings2(String s) {


        int res = 0;

        char[] chars = s.toCharArray();

        boolean[][] flag = new boolean[s.length()][s.length()];


        for (int i = 0; i < chars.length; i++) {

            for (int j = i; j >= 0; j--) {

                if (chars[i] == chars[j] && (i - j < 2 || flag[j + 1][i -1])) {

                    flag[i][j] = true;

                    res++;

                }

            }

        }

        return res;


    }


    public int countSubstrings3(String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        boolean[][] flag = new boolean[chars.length][chars.length];

        for (int i = 0; i < flag.length; i++) {

            for (int j = i; j >=0; j--) {

                if(chars[i] == chars[j] && (i - j < 2 || flag[i-1][j+1])){
                    res++;
                    flag[i][j] = true;
                }
            }

        }

        return res;


    }






    public int countSubstrings4(String s) {

        char[] chars = s.toCharArray();

        int res = 0;

        boolean[][] flag = new boolean[chars.length][chars.length];

        for (int i = 0; i < flag.length; i++) {
            for (int j = i; j>=0 ; j--) {

                if(chars[i] == chars[j] && (i -j <2 || flag[i-1][j+1])){

                    res++;
                    flag[i][j] = true;

                }

            }

        }

        return res;
    }






























}
