package com.wxs.algorithm.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class letterCombinations17 {


    public static void main(String[] args) {

        letterCombinations17 letterCombinations17 = new letterCombinations17();
        List<String> strings = letterCombinations17.letterCombinations("23");
        System.out.println(strings);

    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {


        if(digits.isEmpty()){
            return null;
        }
        generate(digits,0,"");

        return list;
    }

    private void generate(String digits,int index,String s) {

        if(index == digits.length()){
            list.add(s);
            return;
        }

        Character c = digits.charAt(index);

       String le = phone.get(c.toString());

        for (int i = 0; i < le.length(); i++) {

            generate(digits,index+1,le + le.charAt(i));

        }
    }


}
