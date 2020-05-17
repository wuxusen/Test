package com.wxs.algorithm.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class reverseWords557 {

    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String word : words) {
            res.append(new StringBuffer(word).reverse().toString()+" ");
        }

        return res.toString().trim();

    }
}
