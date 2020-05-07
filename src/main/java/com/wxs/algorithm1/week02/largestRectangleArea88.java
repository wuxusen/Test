package com.wxs.algorithm1.week02;

import java.util.Stack;

/**
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class largestRectangleArea88 {


    public static void main(String[] args) {

        int[] arr = {6, 7, 5, 2, 4, 5, 9, 3};

        largestRectangleArea2(arr);
    }


    // 暴力破解时间超时 时间复杂度 n^3 ,空间复杂度 n
    public static int largestRectangleArea(int[] heights) {


        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int high = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    high = Math.min(high, heights[k]);
                }
                maxArea = Math.max(maxArea, (j - i + 1) * high);

            }

        }

        return maxArea;

    }


    // 暴力破解 ，不需要遍历所有的 i 和 j, 之间最低高度，只需要拿到前一个的最低高度
    public static int largestRectangleArea1(int[] heights) {

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;

            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);

                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }

        }

        return maxArea;

    }


    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }


    public static int largestRectangleArea3(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));

            }
            stack.push(i);
        }

        while (stack.peek() != -1) {

            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;

    }


}
