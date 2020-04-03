package com.wxs.algorithm1.week01;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MaxArea11 {

    public static void main(String[] args) {
        int[] arry = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        maxArea5(arry);

    }


    public static int maxArea(int[] height) {

        int res = 0, i = 0, j = height.length - 1;

        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;

    }


    public static int maxArea2(int[] height) {

        int res = 0, i = 0, j = height.length - 1;

        while (i < j) {

            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return res;

    }


    public static int maxArea1(int[] height) {


        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i]);
                i++;

            } else {
                res = Math.max(res, (j - i) * height[j]);
                j--;
            }

        }

        return res;
    }


    public int maxArea4(int[] a) {

        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {

                int area = (j - i) * Math.min(a[i], a[j]);
                max = Math.max(max, area);

            }
        }
        return max;
    }


    public int maxArea3(int[] a) {


        int res = 0, i = 0, j = a.length - 1;

        while (i < j) {

            res = a[i] < a[j] ? Math.max(res, (j - i) * a[i++]) :
                    Math.max(res, (j - i) * a[j--]);

        }
        return res;

    }


    public static int maxArea5(int[] height) {


        int res = 0, i = 0, j = height.length - 1;

        while (i < j) {
            res =   height[j] < height[i] ?
            Math.max(res, (j - i) * height[j--]) :
            Math.max(res, (j - i) * height[i++]);


        }
        return res;
    }


}
