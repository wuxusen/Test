package com.wxs.linked;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-13
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LinkedHashTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);

        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }

    }
}
