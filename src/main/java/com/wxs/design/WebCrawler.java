package com.wxs.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包装类也是值传递
 *
 */
public abstract class WebCrawler {


    public static void main(String[] args) {
        //测试引用传递
        Map<String, String> a = new HashMap<>();
        a.put("1", "a");
        List<Map> b = new ArrayList<Map>();
        b.add(a);
        a = null;
        Map aa = b.get(0);
        System.out.println(aa.get("1"));


        int a1 = 5;

        add(a1);

        System.out.println(a1);

        Integer a2 = new Integer(15);

        add1(a2);

        System.out.println(a2);



    }


    public static void add(int temp) {
        temp = temp + 100;

    }


    public static void add1(Integer temp) {

        temp = new Integer(33);
    }
}
