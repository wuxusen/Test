package com.wxs.lock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestMap {

    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("1", "1");
        paramMap.put("2", "2");
        paramMap.put("3", "3");
        paramMap.put("4", "4");


        Map<String, String> dataParam = new HashMap<>();


        Iterator<String> iterator = paramMap.keySet().iterator();

        while (iterator.hasNext()) {


            for (String s : dataParam.keySet()) {
                if (iterator.next().equals(s)) {

                }
            }

        }
    }


}
