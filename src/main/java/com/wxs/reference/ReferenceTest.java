package com.wxs.reference;

import com.wxs.Person;

import java.lang.ref.WeakReference;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-01-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ReferenceTest {


    public static void main(String[] args) {


        Person person = new Person();
        person.setName("li4");

        String bb = "trrrrr";

        Entry entry = new Entry(person, bb);

        person = null;

       // System.gc();
        System.out.println(entry);


    }



    static class Entry<T> extends WeakReference<T>{

        Object value;

        public Entry(T t,Object value) {
            super(t);
            this.value = value;
        }


    }
}
