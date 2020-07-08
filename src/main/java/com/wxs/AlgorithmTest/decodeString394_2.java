package com.wxs.AlgorithmTest;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class decodeString394_2 {

    public static void main(String[] args) {
        String str = "3[a2[c]]";

        decodeString394_2 de = new decodeString394_2();

        String s = de.decodeString(str);

        System.out.println(s);
    }


    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        Stack<String> str_stack = new Stack<>();
        Stack<Integer> multi_stack = new Stack<>();

        int multi = 0;

        for (Character c : s.toCharArray()) {

            if (c == '[') {
                str_stack.push(res.toString());
                multi_stack.push(multi);

                res = new StringBuilder();
                multi = 0;

            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer times = multi_stack.pop();

                for (int i = 0; i < times; i++){ tmp.append(res);}

                res = new StringBuilder(str_stack.pop() + tmp);

            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c.toString());
            } else {
                res.append(c);
            }


        }

        return res.toString();

    }

}
