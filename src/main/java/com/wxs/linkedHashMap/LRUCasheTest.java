package com.wxs.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LRUCasheTest {


    public static void main(String[] args) {




        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(1000,0.75F,true){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
            }
        };



        map.putIfAbsent(1,1);
        map.putIfAbsent(2,2);
        map.putIfAbsent(3,3);


       Integer orDefault = map.getOrDefault(2, -1);



        for (Integer key : map.keySet()) {
            System.out.println(key);
        }


    }
}
