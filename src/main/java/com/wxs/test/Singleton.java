package com.wxs.test;

public class Singleton {


    private static Singleton instance = new Singleton();

    private static int a = 0;
    private static int b;


    private Singleton() {
        a++;
        b++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

