package com.wxs.thread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {





    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private int flag = 1;

    private final ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();


    public void foo(Runnable printFoo) throws InterruptedException {

        lock.lock();
        for (int i = 0; i < n; i++) {

            while (flag != 1){
                condition.await();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag = 0;
            condition2.signalAll();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {

        lock.lock();
        for (int i = 0; i < n; i++) {

            while (flag != 0){
                condition2.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag = 1;
            condition.signalAll();

        }
        lock.unlock();
    }
}