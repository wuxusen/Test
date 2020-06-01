package com.wxs.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUse {


    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;


    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {

                }
            };
            Thread t = new Thread(r);//新建线程
            t.start();
        }

    }

}

class Bank {
    private final double[] account;//账户
    private Lock bankLock;     //重复锁
    private Condition sufficientFunds;    //条件对象


    public Bank(int n, double initialBalance) {
        account = new double[n];
        Arrays.fill(account, initialBalance);
        bankLock = new ReentrantLock(true);  //构造对象时，实例化锁
        sufficientFunds = bankLock.newCondition();//新建条件对象
    }

    /*转账，把from账户里面的钱转到to里面，金额是amount*/
    public void transfer(int from, int to, double amount) {

        bankLock.lock();
        try {
            while (account[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            account[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            account[to] += amount;
            System.out.printf(" Total Balance : %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    /*做的所有账户总额*/
    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : account) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return account.length;
    }
}