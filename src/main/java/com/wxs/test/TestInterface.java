package com.wxs.test;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public interface TestInterface  {




    default void show(){
        System.out.println("00000");
    }
}


interface A {
    default void say(int a) {
        System.out.println("A");
    }

    default void run() {
        System.out.println("A.run");
    }
}

interface B extends A{
    default void say(int a) {
        System.out.println("B");
    }

    default void play() {
        System.out.println("B.play");
    }
}
interface C extends A,B{


}