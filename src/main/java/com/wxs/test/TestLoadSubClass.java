package com.wxs.test;

public class TestLoadSubClass {
    public static void main(String[] args) {
        //System.out.println(BB.value);
       // AA aa = new AA();
      //  AA[] arrays = new AA[10];

        System.out.println(BB.DESC);
    }
}

class AA {
    static {
        System.out.println("init A ...");
    }

    static int value = 100;
    static final String DESC = "test";
}

class BB extends AA {
    static {
        System.out.println("init B ...");
    }
}