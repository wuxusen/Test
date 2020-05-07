package com.wxs.algorithm1.week03;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class topKFrequent347 {


    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        topKFrequent347 topKFrequent347 = new topKFrequent347();
        topKFrequent347.topKFrequent(arr, k);

    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {


            if(priorityQueue.size() < k){
                priorityQueue.offer(entry);
            }else if ( priorityQueue.peek().getValue() < entry.getValue()) {
                priorityQueue.remove();
                priorityQueue.offer(entry);
            }

        }

        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.remove().getKey());
        }

        return list;

    }
}
