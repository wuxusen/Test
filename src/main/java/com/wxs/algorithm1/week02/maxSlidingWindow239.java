package com.wxs.algorithm1.week02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 类描述  ：给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class maxSlidingWindow239 {


    public static void main(String[] args) {

        int[] a = {5, -1, 3, 5, 6, 11, 33, 6, 7};
        int k = 3;

        maxSlidingWindow2(a, k);
    }

    // 暴力破解 时间复杂度为 O(N*K)  空间复杂度为 O(N - k + 1)

    /**
     * 思路： 通过两边循环，第一遍的长度为 length - k + 1 ，返回数组长度也是 length - k + 1
     * 嵌套循环以i为起点，移动K个坐标，长度小于 i+ k ,每次嵌套循环获取一个最大值，放入数组。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (k * nums.length == 0) {
            return new int[0];
        }

        //  1, 2, 3, 4 ,5 ,6   ,len = 6 - 3 + 1
        int[] ints = new int[nums.length - k + 1];

        for (int i = 0; i < ints.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            ints[i] = max;

        }

        return ints;
    }


    public static int[] maxSlidingWindow3(int[] a, int k) {

        if (a == null || k <= 0) {
            return new int[0];
        }

        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {

            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);

            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }

        }


        return r;

    }


    public static int[] maxSlidingWindow2(int[] a, int k) {


        //  int[] a = {5,-1,3,5,6,11,33,6,7};

        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

}
