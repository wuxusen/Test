package com.wxs.algorithm.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isPerfectSquare367 {


    public static void main(String[] args) {
        isPerfectSquare367 isPerfectSquare367 = new isPerfectSquare367();

        isPerfectSquare367.isPerfectSquare(5);
    }


    public boolean isPerfectSquare(int num) {

        long r = num;
        while(r * r > num){
            r = (r + num / r)/2;
        }

        return r * r == num;

    }


}
