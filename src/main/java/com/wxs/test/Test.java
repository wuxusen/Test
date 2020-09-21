package com.wxs.test;


public class Test {

    public static void main(String[] args) {
        System.out.println(Child.ss);
    }

}

class Parent {

    static {
        System.out.println("Parent init!");
    }

   // public final static String s = "hello";

    public static String ss = "hello";


}

class Child extends Parent {

    static {
        System.out.println("Child init!");
    }

}


