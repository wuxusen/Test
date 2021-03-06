package com.wxs.algorithm1.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class generateParenthesis22 {


    public static void main(String[] args) {

        generateParenthesis22 generateParenthesis22 = new generateParenthesis22();

        generateParenthesis22.generateParenthesis(3);

    }

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        String s = "";

        generate(0, 0, n, s);

        return list;
    }

    private void generate(int left, int right, int max, String s) {


        if (left >= max && right >= max) {
            list.add(s);
            return;
        }
        if (left < max) {
            generate(left + 1, right, max,  s + "(");
        }
        if (left > right) {
            generate(left, right + 1, max, s + ")");
        }
    }


}
