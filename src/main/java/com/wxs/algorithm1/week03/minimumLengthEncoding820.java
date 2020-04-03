package com.wxs.algorithm1.week03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class minimumLengthEncoding820 {


    public static void main(String[] args) {

        minimumLengthEncoding820 minimumLengthEncoding820 = new minimumLengthEncoding820();

        String[] words = {"time", "me", "bell"};

        minimumLengthEncoding820.minimumLengthEncoding(words);

    }

    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: good)
            ans += word.length() + 1;
        return ans;
    }


}
