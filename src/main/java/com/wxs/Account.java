package com.wxs;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

 class MyLock {
  // 测试转账的main方法
  public static void main(String[] args) throws InterruptedException {

  }
  static class Account{ //账户类
    public Account(Integer banalce) {
      this.banalce = banalce;
    }
    private Integer banalce;
    public void transactionToTarget(Integer money,Account target){//转账方法
      Allocator.getInstance().apply(this,target);
      this.banalce -= money;
      target.setBanalce(target.getBanalce()+money);
      Allocator.getInstance().release(this,target);



    }
    public Integer getBanalce() {
      return banalce;
    }
    public void setBanalce(Integer banalce) {
      this.banalce = banalce;
    }
  }
  static class Allocator { //单例锁类
    private Allocator(){}
    private List<Account> locks = new ArrayList<>();

    public synchronized void apply(Account src,Account tag){

      while (locks.contains(src) || locks.contains(tag)){

        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        locks.add(src);
        locks.add(tag);

      }

    }
    public synchronized void release(Account src,Account tag){
      locks.remove(src);
      locks.remove(tag);
      notifyAll();

    }
    public static Allocator getInstance(){
      return AllocatorSingle.install;
    }
    static class AllocatorSingle{
      public static Allocator install = new Allocator();
    }
  }
}