package com.wxs.AlgorithmTest;

import java.util.LinkedList;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class decodeString394_1 {

    public static void main(String[] args) {
        String str = "3[a2[c]]";

        decodeString394_1 de = new decodeString394_1();

        String s = de.decodeString(str);

        System.out.println(s);
    }



    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()){
            if(c == '['){
            stack_multi.addLast(multi);
            multi = 0;

            stack_res.add(res.toString());
            res = new StringBuilder();

            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++){
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }else if(c >= '0' && c <= '9'){
                multi = multi*10 + Integer.parseInt(c.toString());
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
