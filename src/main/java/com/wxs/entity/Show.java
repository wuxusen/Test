package com.wxs.entity;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-12-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Show<K1> {



    public <T> T getInfo(K1 t){

        return (T) new String();
    }



    public static void main(String[] args) {


        Show<Object> objectShow = new Show<>();

        Object info = objectShow.getInfo(new String());




    }




}
