package com.wxs.algorithm1.week03;



/**
 * 类描述  ：
 * <p>
 * 思路： 求数组中相同数，出现的次数，然后求最大公约数，如果最大公约数为1，则跳出
 * <p>
 * <p>
 * <p>
 * <p>
 * 创建人  : 吴绪森
 * 创建时间：2020-03-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class hasGroupsSizeX914 {

    public boolean hasGroupsSizeX(int[] deck) {


        int[] counter = new int[10000];


        for (int i : counter) {

            counter[i]++;
        }

        int x = 0;
        for (int i : counter) {

            if (i > 0) {

                x = gcd(x, i);
                if (x == 1) {
                    return false;
                }
            }
        }

        return x >= 2 ;
    }


    public int gcd(int i, int j){
        return j == 0 ? i:gcd(j,i%j);
    }



}
