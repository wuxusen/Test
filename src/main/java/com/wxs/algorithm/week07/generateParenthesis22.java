package com.wxs.algorithm.week07;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class generateParenthesis22 {
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        generateParenthesis22 generateParenthesis22 = new generateParenthesis22();

        List<String> strings = generateParenthesis22.generateParenthesis(3);


        System.out.println(strings);
    }


    public List<String> generateParenthesis(int n) {


        String str = "";


        backtrack(0,0,n,str);


        return list;

    }


   public void backtrack(int left,int right,int n,String str){


        if(left == n && right == n){
             list.add(str);
            return;
        }


        if(left >= right && left <= n){
            backtrack(left+1,right,n,str+"(");
        }

        if(left > right){

            backtrack(left,right+1,n,str+")");

        }

   }

}
