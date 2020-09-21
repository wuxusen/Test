package com.wxs.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-08-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class StringTest {




    private static final Map<String, Person> ppp = new HashMap<String, Person>(){{


        put("all", new Man());
        put("InsightProject", new Person());

    }};






    public static void main(String[] args) throws Exception {
        String a = "abc";

        String b = new String("abc");


        System.out.println(a == b);


        Person all = ppp.get("all");
        Person all1 = ppp.get("all");
        Person all2 = ppp.get("all");
        Person all3 = ppp.get("all");
        Person all4 = ppp.get("all");


        System.out.println("-----------");


        int num = 2147483647;
        num += 2L;
        System.out.println(num);



    }
}
