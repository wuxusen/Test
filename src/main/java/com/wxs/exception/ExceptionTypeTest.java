package com.wxs.exception;

public class ExceptionTypeTest {
    public void doSomething() throws ArithmeticException {
        System.out.println();
    }

    public static void main() {
        ExceptionTypeTest ett = new ExceptionTypeTest();
        ett.doSomething();
    }
}