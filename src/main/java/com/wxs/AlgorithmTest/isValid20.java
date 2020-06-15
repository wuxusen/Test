package com.wxs.AlgorithmTest;

import java.util.HashMap;
import java.util.Map;
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

public class isValid20 {


    public static Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {

                char a = stack.isEmpty() ? '!' : stack.pop();

                if (a != map.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }


        }
        return stack.isEmpty();

    }
}
