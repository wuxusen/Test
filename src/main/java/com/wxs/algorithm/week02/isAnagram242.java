package com.wxs.algorithm.week02;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isAnagram242 {


    public static void main(String[] args) {


       String s = "anagram", t = "nagaram";
        isAnagram242 isAnagram242 = new isAnagram242();
        isAnagram242.isAnagram(s,t);
    }






    /**
     *  时间复杂度 O(n)
     *  空间复杂度 O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }


        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {

            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i : counter) {


            if(i != 0){
                return false;
            }

        }

        return true;


    }



    /**
     *
     * 排序的时间复杂度：O(nlogn)
     *
     * java 实现的空间复杂度： O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if(s == null || t == null ){
            return false;
        }

        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();
        Arrays.sort(sb);
        Arrays.sort(tb);

        if(Arrays.equals(tb,sb)){
            return true;
        }

        return false;

    }



}
