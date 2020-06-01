package com.wxs.thread.happensBefore;

import com.wxs.Person;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestThread {


    public static void main(String[] args) {

    }

}


class PlusAdd extends Thread{

   private Person person;

    @Override
    public void run() {
        person.setAge(person.getAge() + 1);
    }
}