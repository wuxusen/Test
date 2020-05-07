package com.wxs.algorithm.week03;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-01
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class pow50 {


    public static void main(String[] args) {
        pow50 pow50 = new pow50();
        pow50.myPow(2L, 2);
    }


    private double fastPow(double x, long n) {

        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }


    }


    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);

    }


}
