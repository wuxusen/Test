package com.wxs.algorithm.week03;

import java.util.PriorityQueue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class getLeastNumbers40 {




    // 这种方式 是将所有的数组元素放入小顶堆中，空间复杂度就是O(logN) ,最优为O(logK)
    // 默认小顶堆，全遍历后，会依次记录 从小到大的值，取前k, 所以不用重写比较器
    public int[] getLeastNumbers(int[] arr, int k) {


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        for (int i : arr) {
            priorityQueue.add(i);
        }

        int i = 0;
        int[] least = new int[k];
        while (i < k && !priorityQueue.isEmpty()) {
            least[i++] = priorityQueue.poll();


        }

        return least;
    }

    // 如果取前k个，使用nlogK的时间复杂度，那需要重写比较器，实现大顶堆，用最大的值来比较是否入堆
    public int[] getLeastNumbers1(int[] arr, int k) {


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1,v2)->v2 - v1);


        for (int i : arr) {
            if(priorityQueue.size() < k){
                priorityQueue.offer(i);
            }else if(priorityQueue.peek() > i){
              priorityQueue.poll();
              priorityQueue.offer(i);
            }
        }

        int[] arrK = new int[priorityQueue.size()];

        int index = 0;
        for (Integer v : priorityQueue) {

            arrK[index++] = v;
        }

        return arrK;
    }

}
