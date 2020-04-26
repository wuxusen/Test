package com.wxs.algorithm1.week02;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isValid20 {


    public static void main(String[] args) {

        isValid20 isValid20 = new isValid20();
        String str = "()";
        isValid20.isValid(str);

    }


    private static Map<Character, Character> MAPPINGS = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };


    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);


            if (MAPPINGS.containsKey(c)) {

                char pop = stack.isEmpty() ? '!' : stack.pop();

                if (pop != MAPPINGS.get(c)) {
                    return false;
                }


            } else {

                stack.push(c);

            }
        }


        return stack.isEmpty();

    }


    public boolean isValid1(String s) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);


            if(MAPPINGS.containsKey(c)){


               char pop =  stack.isEmpty() ? '1' : stack.pop();

                if(pop != MAPPINGS.get(c)){

                    return false;
                }



            }



        }
        return stack.isEmpty();

    }
}
