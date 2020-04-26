package com.wxs.algorithm.week03;

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




    private void generate1(int left, int right ,int n,String str){


        if(left>= n && right>= n){
            list.add(str);
            return;
        }

        if(right<=left && left <n)
        generate1(left+1,right,n,str+"(");

        if (left >= right)
        generate1(left,right+1,n,str+")");


    }



}
