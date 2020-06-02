package com.wxs.thread.aqs;

class Foo {

    public Foo() {
        
    }

    private volatile boolean first = false;
    private volatile  boolean second = false;


    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (!first){}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!second){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}