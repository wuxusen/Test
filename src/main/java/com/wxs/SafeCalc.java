package com.wxs;


public  class  SafeCalc {

  static long value = 0L;


  synchronized long get() {

    System.out.println("------get----------------");

    return value;

  }


  synchronized static void addOne() {


    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("------addone----------------"+ Thread.currentThread().getName());

    value += 1;

  }


  public static void main(String[] args) throws InterruptedException {

    SafeCalc safeCalc = new SafeCalc();

    Thread t1 = new Thread(()->{
      SafeCalc.addOne();


    });
    t1.setName("t1");

    Thread t2 = new Thread(()->{

      safeCalc.get();

    });

    t2.setName("t2");

    t1.start();

    t2.start();




  }





}
