package com.wxs;

import java.util.concurrent.atomic.AtomicLong;

public class Test {


  AtomicLong count = new AtomicLong(0);

  private void add() {

    int idx = 0;

    while(idx++ < 10000000) {
      count.getAndIncrement();
    }
  }
  public static AtomicLong calc() throws Exception {
    final Test test = new Test();
    Thread th1 = new Thread(()->{
      test.add();
    });
    Thread th2 = new Thread(()->{
      test.add();
    });

    th1.start();
    th2.start();
    th1.join();
    th2.join();
    return test.count;
  }

  public static void main(String[] args) throws Exception {
//    AtomicLong c =calc();
//    System.out.println(c);



    Person person1 = new Person();
    Person person2 = new Person();


    new Thread(() -> {
      synchronized (person1) {

        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (person2) {

        }


      }


    }).start();


    new Thread(() -> {

      synchronized (person2) {

        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (person1) {


        }


      }


    }).start();


  }

  }
