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

public class decodeString394_3 {

    public static void main(String[] args) {
        String str = "3[a2[c]]";

        decodeString394_3 de = new decodeString394_3();

        String s = de.decodeString(str);

        System.out.println(s);
    }


    /**
     * 需要两个栈来存放数值和字母
     * 遍历字符串，当为 ']' 从栈里拿出数值 和字母进行处理
     * 字符串方便处理，可以使用Stringbuild
     * @param s
     * @return
     */
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        Stack<Integer> muilt_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();

        int muilt = 0;

        for(int i = 0; i < s.length(); i++){

            Character c = s.charAt(i);
            if(c == '['){

                str_stack.push(res.toString());
                muilt_stack.push(muilt);

                muilt = 0;
                res = new StringBuilder();

            }else if(c == ']'){

                int times = muilt_stack.pop();

                StringBuilder tmp = new StringBuilder();

                for(int j = 0 ; j < times ;j++){
                    tmp.append(res);
                }

                res = new StringBuilder(str_stack.pop()+tmp);

            }else if(c >= '0' && c <= '9'){

                muilt = muilt * 10 + Integer.parseInt(c.toString());

            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
