package com.wxs.algorithm.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class validPalindrome680 {


    public static void main(String[] args) {
        validPalindrome680 validPalindrome680 = new validPalindrome680();
        validPalindrome680.validPalindrome("caba");
    }
    public boolean validPalindrome(String s) {
        int l= -1,r = s.length();
        while (++l < --r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindromic(s,l,r+1) || isPalindromic(s,l-1,r);
            }
        }
        return true;
    }

    private boolean isPalindromic(String s, int l, int r) {

        while (++l < --r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
        }
        return true;
    }
}
