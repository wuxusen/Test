package com.wxs.algorithm;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class climbStairsTest70 {


    public static void main(String[] args) {

        int climb = climb(44);
        System.out.println(climb);

    }


    // 时间复杂度为 2^n  空间复杂度 O（n）
    public static int climb(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        return climb(n - 1) + climb(n - 2);
    }

    public static int climb3(int n, int[] arry) {

        if (n == 1 || n == 2) {
            return n;
        }

        if (arry[n] > 0) {
            return arry[n];
        }

        arry[n] = climb3(n - 1, arry) + climb3(n - 2, arry);

        return arry[n];
    }


    // 时间复杂度为 n  空间复杂度 O（n）
    public static int climb1(int i, int n) {

        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        return climb1(i + 1, n) + climb1(i + 2, n);
    }


    public static int climb2(int i, int n, int[] arry) {

        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (arry[i] > 0) {
            return arry[i];
        }

        arry[i] = climb2(i + 1, n, arry) + climb2(i + 2, n, arry);
        return arry[i];
    }

    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }

    /**
     * 斐波那契数列 f(n) = f(n -1) + f(n-1)
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {

        if (n == 1) {
            return 1;
        }
        int one = 1;
        int two = 2;

        for (int i = 3; i <= n; i++) {
            int three = one + two;
            one = two;
            two = three;
        }
        return two;
    }


    public int climbStairs2(int n, int[] arry) {


        if (n == 1 || n == 2) {
            return n;
        }

        if (arry[n] > 0) {
            return arry[n];
        }

        arry[n] = climbStairs2(n - 1, arry) + climbStairs2(n - 2, arry);

        return arry[n];

    }

    // 时间复杂度为O(n) ,空间复杂度为O(1)
    public int climbStairs3(int n) {


        if (n == 1 || n == 2) {
            return n;
        }

        int one = 1;
        int two = 2;

        for (int i = 3; i <= n; i++) {
            int three = one + two;
            one = two;
            two = three;

        }

        return two;

    }


    /**
     * 2020年03月13日11:18:02
     */


    public int climbStairs4(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs4(n - 1) + climbStairs3(n - 2);
    }


    public int climbStairs5(int n, int[] arr) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (arr[n] > 0) {
            return arr[n];
        }
        arr[n] = climbStairs5(n - 1, arr) + climbStairs5(n - 2, arr);
        return arr[n];
    }


    public int climbStairs6(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int one = 1;
        int two = 2;

        for (int i = 3; i <= n; i++) {

            int three = one + two;
            one = two;
            two = three;
        }


        return two;
    }


    // 爬楼梯问题 可以用斐波拉契 解决 迭代

    public int climbStairs7(int n) {


        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs7(n - 1) + climbStairs7(n - 2);
    }


    public int climbStairs8(int n, int[] arry) {


        if (n == 1 || n == 2) {
            return n;
        }

        if (arry[n] > 0) {
            return arry[n];
        }
        arry[n] = climbStairs8(n - 1, arry) + climbStairs8(n - 2, arry);
        return arry[n];
    }

    // 动态规划   定义和楼梯数等长的数组，用来记录到n个台阶的方式，且，fn = f(n -1)+f( n - 2)

    public int climbStairs9(int n){



        if(n == 1 || n ==2){
            return n;
        }

        int[] arr = new int[n -1];

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < arr.length; i++) {
           arr[i] = arr[i - 1] + arr[i -2];
        }

        return arr[n];

    }


}
