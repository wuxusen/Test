package com.wxs.interfaceTest;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/6/14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestCache {
    public static void main(String[] args) {

        CahcheAbs abs =   new CahcheAbs(){

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object delete(Object key) {
                return null;
            }
        };



    }
}
