package com.wxs.algorithm.week03;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class nthUglyNumber264 {



    public static Ugly u = new Ugly();


    public static void main(String[] args) {
        nthUglyNumber264 nthUglyNumber264 = new nthUglyNumber264();
        nthUglyNumber264.nthUglyNumber(10);
    }
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }


    public int nthUglyNumber1(int n){

        int[] nums = new int[n];
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        seen.add(1L);
        priorityQueue.add(1L);


        long curr , newUg;

        int [] primes = new int[]{2,3,5};

        for (int i = 0; i < n; i++) {

            curr = priorityQueue.poll();
            nums[i] = (int) curr;

            for (int prime : primes) {

                newUg = curr * prime;

                if(!seen.contains(newUg)){
                    seen.add(newUg);
                    priorityQueue.add(newUg);
                }
            }

        }

        return nums[n -1 ];
    }


}
class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);

        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for(int i = 0; i < 1690; ++i) {
            currUgly = heap.poll();
            nums[i] = (int)currUgly;
            for(int j : primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}
