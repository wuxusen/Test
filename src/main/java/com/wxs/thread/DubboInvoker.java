package com.wxs.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DubboInvoker {


    public static void main(String[] args) throws InterruptedException {

        TcpService tcpService = new TcpService();

        String res = tcpService.query().get();

        System.out.println(res);


    }



}

class TcpService{



    Lock lock  = new ReentrantLock();

    Condition done = lock.newCondition();


    private String res;




    public TcpService query(){
        Query query = new Query(this);
        Thread thread = new Thread(query);
        thread.start();
        return this;
    }


    // 调用方通过该方法等待结果
    String get() throws InterruptedException {
        long start = System.nanoTime();
        lock.lock();
        try {
            while (!isDone()) {
                done.await();
            }
        } finally {
            lock.unlock();
        }
        if (!isDone()) {
            throw new RuntimeException();
        }
        return getRes();
    }
    // RPC 结果是否已经返回
    boolean isDone() {
        return res != null;
    }



    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }


    // RPC 结果返回时调用该方法
    public void doReceived(String res) {
        lock.lock();
        try {
            this.res = res;
            if (done != null) {
                done.signal();
            }
        } finally {
            lock.unlock();
        }
    }


}


class Query implements Runnable{

    private TcpService tcpService;

    public Query(TcpService tcpService){
        this.tcpService = tcpService;
    }

    @Override
    public void run() {

        try {
            System.out.println("正在发送请求=============");
            Thread.sleep(10000L);
            System.out.println("结果返回=================");
            tcpService.doReceived("异步调用执行完成！==========");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


