package com.wxs.algorithm1.week03;

import java.util.ArrayDeque;
import java.util.Deque;
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

public class maxSlidingWindow239 {


    public static void main(String[] args) {
        maxSlidingWindow239 maxSlidingWindow239 = new maxSlidingWindow239();

        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow239.maxSlidingWindow3(arr, k);
        System.out.println(ints);


    }



    public int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) {
                result[index++] = max.peekFirst();
            }
        }
        return result;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums.length < 1 || k < 1) {
            return new int[0];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            if (priorityQueue.size() >= k) {
                priorityQueue.remove(nums[i - k]);
            }

            priorityQueue.offer(nums[i]);

            if (i >= k - 1) {
                arr[i - k + 1] = priorityQueue.peek();
            }

        }
        return arr;
    }

    // 滑动窗口，上来就遍历，两次遍历，第一次是全量遍历，第二次遍历 起始位置是以为起点，移动i+k ,相当于滑动了k次，
    // 在滑动K次后找max值
    public int[] maxSlidingWindow(int[] nums, int k) {


        if (nums.length < 1 || k < 1) {
            return new int[0];
        }

        int[] arr = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            int max = Integer.MIN_VALUE;

            for (int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
            }

            arr[i] = max;


        }
        return arr;

    }


}
